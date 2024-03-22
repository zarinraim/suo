package com.zarinraim.accounting.scene

import com.zarinraim.accounting.scene.ChartAccountsViewModel.State
import com.zarinraim.accounting.utils.StatefulViewModel
import com.zarinraim.accounting.utils.ViewModelState

class ChartAccountsViewModel : StatefulViewModel<State>(State()) {

    init {
        state = State(accounts = listOf("Test"))
    }

    data class State(
        val accounts: List<String> = emptyList()
    ) : ViewModelState
}