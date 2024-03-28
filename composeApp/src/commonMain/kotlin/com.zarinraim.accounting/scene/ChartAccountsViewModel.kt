package com.zarinraim.accounting.scene

import com.zarinraim.accounting.domain.ChartAccountRepository
import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.ChartAccount
import com.zarinraim.accounting.model.ClassAccount
import com.zarinraim.accounting.model.SyntheticAccount
import com.zarinraim.accounting.presentation.ChartAccountFormat
import com.zarinraim.accounting.presentation.ClassItemState
import com.zarinraim.accounting.presentation.GroupItemState
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
        state = state.update { classAccount -> updateClassExpanded(code, classAccount) }
    }

    fun onQueryChange(query: String) {
        state = state.copy(
            searchQuery = query.trimStart(),
            filteredAccounts = filter(query).map(ChartAccountFormat::format),
        )
    }

    fun onQueryClear() {
        state = state.copy(
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

    private fun updateClassExpanded(code: AccountId, classAccount: ClassItemState) = when {
        classAccount.code.classNumber == code.classNumber -> classAccount.copy(
            expanded = if (code.groupNumber != null) classAccount.expanded else !classAccount.expanded,
            groupAccounts = classAccount.groupAccounts.map { groupAccount -> updateGroupExpanded(code, groupAccount) }
        )
        classAccount.expanded -> classAccount.copy(expanded = false)
        else -> classAccount
    }

    private fun updateGroupExpanded(code: AccountId, groupAccount: GroupItemState) = when {
        groupAccount.code.groupNumber == code.groupNumber -> groupAccount.copy(expanded = !groupAccount.expanded)
        groupAccount.expanded -> groupAccount.copy(expanded = false)
        else -> groupAccount
    }

    private fun ChartAccount.toState() = State(
        accounts = classAccounts.let { ChartAccountFormat.format(classAccounts = it, expandDefault = false) },
        data = classAccounts
    )

    private fun State.update(update: (ClassItemState) -> ClassItemState) = copy(
        accounts = state.accounts.map(update)
    )

    data class State(
        val searchQuery: String = "",
        val filteredAccounts: List<SyntheticItemState> = emptyList(),
        val accounts: List<ClassItemState> = emptyList(),
        internal val data: List<ClassAccount> = emptyList()
    ) : ViewModelState
}