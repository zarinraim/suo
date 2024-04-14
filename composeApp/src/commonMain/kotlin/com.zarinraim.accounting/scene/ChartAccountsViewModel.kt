package com.zarinraim.accounting.scene

import androidx.lifecycle.viewModelScope
import com.zarinraim.accounting.domain.ChartAccountUseCase
import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.ChartFilter
import com.zarinraim.accounting.model.Feature
import com.zarinraim.accounting.presentation.AccountsState
import com.zarinraim.accounting.presentation.ChartAccountFormat
import com.zarinraim.accounting.presentation.FeatureFormat
import com.zarinraim.accounting.presentation.FeatureState
import com.zarinraim.accounting.scene.ChartAccountsViewModel.State
import com.zarinraim.accounting.utils.StatefulViewModel
import com.zarinraim.accounting.utils.ViewModelState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ChartAccountsViewModel(
    private val fetchAccounts: ChartAccountUseCase.Fetch,
    private val observeAccounts: ChartAccountUseCase.Observe,
    private val applyFilter: ChartAccountUseCase.ApplyFilter,
    private val resetFilter: ChartAccountUseCase.ResetFilter,
) : StatefulViewModel<State>(State()) {

    init {
        fetch()
        observe()
    }

    fun onAccount(code: AccountId) {
        state = state.copy(accounts = state.accounts.toggle(code))
    }

    fun onQueryChange(query: String) {
        state = state.copy(
            chartFilter = state.chartFilter.copy(query = query),
            searchQuery = query.trimStart(),
        )
        applyFilter(state.chartFilter)
    }

    fun onRefresh() {
        state = state.copy(
            searchQuery = "",
            features = filterFeatures,
            chartFilter = emptyFilter,
            accounts = state.accounts.collapseAll()
        )
        resetFilter()
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
        fetchAccounts()
    }

    private fun observe() = viewModelScope.launch {
        observeAccounts().collectLatest { chart ->
            state = state.copy(
                accounts = ChartAccountFormat.format(classAccounts = chart.classAccounts, expandDefault = !state.isFilterEmpty())
            )
        }
    }

    private fun filter() = viewModelScope.launch {
        state = state.copy(
            chartFilter = state.chartFilter.copy(
                features = state.features.filter { it.selected }.map { it.type }.toSet()
            )
        )
        applyFilter(state.chartFilter)
    }

    private companion object {

        val emptyFilter = ChartFilter(features = emptySet(), query = "")
        val filterFeatures = Feature.entries.map(FeatureFormat::format)
    }

    data class State(
        val chartFilter: ChartFilter = emptyFilter,
        val searchQuery: String = "",
        val accounts: AccountsState = AccountsState(emptyList()),
        val features: List<FeatureState> = filterFeatures,
    ) : ViewModelState {

        fun isFilterEmpty() = chartFilter == emptyFilter
    }
}