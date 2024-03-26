package com.zarinraim.accounting.scene

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.zarinraim.accounting.utils.getViewModel

@Composable
fun ChartAccountsScreen(viewModel: ChartAccountsViewModel = getViewModel()) {
    val state = viewModel.states.collectAsState().value

    LazyColumn {
        items(state.accounts) {
            Text(text = it)
        }
    }
}