package com.zarinraim.accounting.scene

import androidx.lifecycle.viewModelScope
import com.zarinraim.accounting.domain.ChartAccountUseCase
import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.ChartAccount
import com.zarinraim.accounting.model.ClassAccount
import com.zarinraim.accounting.model.Feature
import com.zarinraim.accounting.model.SyntheticAccount
import com.zarinraim.accounting.presentation.AccountsState
import com.zarinraim.accounting.presentation.ChartAccountFormat
import com.zarinraim.accounting.presentation.FeatureFormat
import com.zarinraim.accounting.presentation.FeatureState
import com.zarinraim.accounting.presentation.SyntheticItemState
import com.zarinraim.accounting.scene.ChartAccountsViewModel.State
import com.zarinraim.accounting.utils.StatefulViewModel
import com.zarinraim.accounting.utils.ViewModelState
import com.zarinraim.accounting.utils.normalize
import kotlinx.coroutines.launch

class ChartAccountsViewModel(
    private val fetchAccounts: ChartAccountUseCase.Fetch,
    private val filterAccounts: ChartAccountUseCase.Filter,
) : StatefulViewModel<State>(State()) {

    init {
        fetch()
    }

    fun onAccount(code: AccountId) {
        state = state.copy(accounts = state.accounts.toggle(code))
    }

    fun onQueryChange(query: String) {
        state = state.copy(
            searchQuery = query.trimStart(),
            filteredAccounts = search(query).map { ChartAccountFormat.format(it, true) },
        )
    }

    fun onRefresh() {
        state = state.copy(
            accounts = ChartAccountFormat.format(classAccounts = state.data, expandDefault = false),
            searchQuery = "",
            filteredAccounts = emptyList(),
        )
    }

    fun onFeature(item: FeatureState) {
        state = state.copy(
            features = state.features.map { feature ->
                if (item == feature) feature.copy(selected = !item.selected)
                else feature
            },
        )
        filter()
    }

    private fun fetch() = viewModelScope.launch {
        state = fetchAccounts().toState()
    }

    private fun filter() = viewModelScope.launch {
        val filtered = filterAccounts(state.features.filter { it.selected }.map { it.type }.toSet())
        state = state.copy(
            accounts = ChartAccountFormat.format(classAccounts = filtered.classAccounts, expandDefault = false),
        )
    }

    private fun search(query: String): List<SyntheticAccount> {
        return state.data
            .flatMap { classAccount ->
                classAccount.groupAccounts.flatMap { groupAccount -> groupAccount.syntheticAccounts }
            }
            .filter { syntheticAccount ->
                syntheticAccount.id.code.contains(query) || syntheticAccount.id.title.containsInTitle(query)
            }
    }

    private fun String.containsInTitle(other: String) = normalize().contains(other = other, ignoreCase = true)

    private fun ChartAccount.toState() = State(
        accounts = ChartAccountFormat.format(classAccounts = classAccounts, expandDefault = false),
        data = classAccounts,
        features = Feature.entries.map(FeatureFormat::format)
    )

    data class State(
        val searchQuery: String = "",
        val filteredAccounts: List<SyntheticItemState> = emptyList(),
        val accounts: AccountsState = AccountsState(emptyList()),
        val features: List<FeatureState> = emptyList(),
        internal val data: List<ClassAccount> = emptyList(),
    ) : ViewModelState
}