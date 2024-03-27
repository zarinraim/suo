package com.zarinraim.accounting.scene

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zarinraim.accounting.presentation.ClassItemState
import com.zarinraim.accounting.presentation.GroupItemState
import com.zarinraim.accounting.utils.getViewModel

@Composable
fun ChartAccountsScreen(viewModel: ChartAccountsViewModel = getViewModel()) {
    val state = viewModel.states.collectAsState().value

    LazyColumn {
        state.accounts.forEach { classItem ->
            classes(classItem)
        }
    }
}

private fun LazyListScope.classes(
    state: ClassItemState,
) {
    item {
        AccountItem(number = state.number, title = state.title)
    }

    state.groupAccounts.forEach { groupItem ->
        groups(groupItem)
    }
}

private fun LazyListScope.groups(
    state: GroupItemState,
) {
    item {
        AccountItem(number = state.number, title = state.title)
    }

    items(state.syntheticAccounts) { accountItem ->
        AccountItem(number = accountItem.number, title = accountItem.title)
    }
}

@Composable
private fun AccountItem(
    number: String,
    title: String
) {
    Row(
        modifier = Modifier.padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(number)
        Spacer(modifier = Modifier.size(size = 16.dp))
        Text(title)
    }
}