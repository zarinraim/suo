package com.zarinraim.accounting.scene

import com.zarinraim.accounting.domain.ChartAccountRepository
import com.zarinraim.accounting.model.ChartAccount
import com.zarinraim.accounting.model.ClassAccount
import com.zarinraim.accounting.model.GroupAccount
import com.zarinraim.accounting.model.SyntheticAccount
import com.zarinraim.accounting.presentation.ClassItemState
import com.zarinraim.accounting.presentation.GroupItemState
import com.zarinraim.accounting.presentation.SyntheticItemState
import com.zarinraim.accounting.scene.ChartAccountsViewModel.State
import com.zarinraim.accounting.utils.StatefulViewModel
import com.zarinraim.accounting.utils.ViewModelState

class ChartAccountsViewModel(
    chartAccountRepository: ChartAccountRepository,
) : StatefulViewModel<State>(State()) {

    init {
        state = chartAccountRepository.fetch().toState()
    }

    private fun ChartAccount.toState() = State(
        accounts = classAccounts.map { it.toState() }
    )

    private fun ClassAccount.toState() = ClassItemState(
        number = id.code,
        title = id.title,
        groupAccounts = groupAccounts.map { it.toState() }
    )

    private fun GroupAccount.toState() = GroupItemState(
        number = id.code,
        title = id.title,
        syntheticAccounts = syntheticAccounts.map { it.toState() }
    )

    private fun SyntheticAccount.toState() = SyntheticItemState(
        number = id.code,
        title = id.title
    )

    data class State(
        val accounts: List<ClassItemState> = emptyList()
    ) : ViewModelState
}