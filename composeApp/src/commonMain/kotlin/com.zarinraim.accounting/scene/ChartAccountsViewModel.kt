package com.zarinraim.accounting.scene

import com.zarinraim.accounting.domain.ChartAccountRepository
import com.zarinraim.accounting.model.ChartAccount
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
        accounts = classAccounts.map {
            "${it.id.code} ${it.id.title}"
        }
    )

    data class State(
        val accounts: List<String> = emptyList()
    ) : ViewModelState
}