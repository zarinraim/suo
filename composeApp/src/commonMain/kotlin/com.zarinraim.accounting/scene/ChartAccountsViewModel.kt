package com.zarinraim.accounting.scene

import com.zarinraim.accounting.domain.ChartAccountRepository
import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.ChartAccount
import com.zarinraim.accounting.model.ClassAccount
import com.zarinraim.accounting.model.SyntheticAccount
import com.zarinraim.accounting.presentation.AccountsState
import com.zarinraim.accounting.presentation.ChartAccountFormat
import com.zarinraim.accounting.presentation.SyntheticItemState
import com.zarinraim.accounting.scene.ChartAccountsViewModel.State
import com.zarinraim.accounting.utils.StatefulViewModel
import com.zarinraim.accounting.utils.ViewModelState
import com.zarinraim.accounting.utils.normalize

class ChartAccountsViewModel(
    chartAccountRepository: ChartAccountRepository,
) : StatefulViewModel<State>(State()) {

    init {
        state = chartAccountRepository.fetch().toState()
    }

    fun onAccount(code: AccountId) {
        state = state.copy(accounts = state.accounts.toggle(code))
    }

    fun onQueryChange(query: String) {
        state = state.copy(
            searchQuery = query.trimStart(),
            filteredAccounts = filter(query).map(ChartAccountFormat::format),
        )
    }

    fun onRefresh() {
        state = state.copy(
            accounts = state.accounts.collapseAll(),
            searchQuery = "",
            filteredAccounts = emptyList(),
        )
    }

    private fun filter(query: String): List<SyntheticAccount> {
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
        data = classAccounts
    )

    data class State(
        val searchQuery: String = "",
        val filteredAccounts: List<SyntheticItemState> = emptyList(),
        val accounts: AccountsState = AccountsState(emptyList()),
        internal val data: List<ClassAccount> = emptyList(),
    ) : ViewModelState
}