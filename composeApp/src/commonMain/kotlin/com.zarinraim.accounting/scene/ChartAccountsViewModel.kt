package com.zarinraim.accounting.scene

import com.zarinraim.accounting.domain.ChartAccountRepository
import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.ChartAccount
import com.zarinraim.accounting.presentation.ChartAccountFormat
import com.zarinraim.accounting.presentation.ClassItemState
import com.zarinraim.accounting.presentation.GroupItemState
import com.zarinraim.accounting.scene.ChartAccountsViewModel.State
import com.zarinraim.accounting.utils.StatefulViewModel
import com.zarinraim.accounting.utils.ViewModelState

class ChartAccountsViewModel(
    chartAccountRepository: ChartAccountRepository,
) : StatefulViewModel<State>(State()) {

    init {
        state = chartAccountRepository.fetch().toState()
    }

    fun onAccount(code: AccountId) {
        state = state.update { classAccount -> updateClassExpanded(code, classAccount) }
    }

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
        accounts = classAccounts.let(ChartAccountFormat::format)
    )

    private fun State.update(update: (ClassItemState) -> ClassItemState) = copy(
        accounts = state.accounts.map(update)
    )

    data class State(
        val accounts: List<ClassItemState> = emptyList()
    ) : ViewModelState
}