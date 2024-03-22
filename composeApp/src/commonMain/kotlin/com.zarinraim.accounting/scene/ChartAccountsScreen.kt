package com.zarinraim.accounting.scene

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.zarinraim.accounting.utils.getViewModel

@Composable
fun ChartAccountsScreen(viewModel: ChartAccountsViewModel = getViewModel()) {
    val state = viewModel.states.collectAsState().value

    state.accounts.forEach {
        Text(text = "text: $it")
    }
}