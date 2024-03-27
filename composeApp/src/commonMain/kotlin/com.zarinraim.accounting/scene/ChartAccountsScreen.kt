package com.zarinraim.accounting.scene

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.presentation.ClassItemState
import com.zarinraim.accounting.presentation.GroupItemState
import com.zarinraim.accounting.scene.component.ItemDisplay
import com.zarinraim.accounting.scene.component.ItemDropDownPrimary
import com.zarinraim.accounting.scene.component.ItemDropDownSecondary
import com.zarinraim.accounting.scene.component.VerticalSpacer
import com.zarinraim.accounting.utils.getViewModel

@Composable
fun ChartAccountsScreen(viewModel: ChartAccountsViewModel = getViewModel()) {
    val state = viewModel.states.collectAsState().value

    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        state.accounts.forEachIndexed { index, classItem ->
            if (index != 0) item { VerticalSpacer(8.dp) }
            classItem(
                state = classItem,
                onAccount = viewModel::onAccount,
            )
        }

        item { VerticalSpacer(16.dp) }
    }
}

private fun LazyListScope.classItem(
    state: ClassItemState,
    onAccount: (AccountId) -> Unit,
) {
    item {
        ItemDropDownPrimary(
            number = state.number,
            title = state.title,
            expanded = state.expanded,
            backgroundColor = state.background.primaryColor,
            onClick = { onAccount(state.code) }
        )
    }

    if (state.expanded) {
        state.groupAccounts.forEach { groupItem ->
            item { VerticalSpacer(4.dp) }
            groupItem(
                state = groupItem,
                backgroundColor = state.background.secondaryColor,
                onItem = onAccount
            )
        }
    }
}

private fun LazyListScope.groupItem(
    state: GroupItemState,
    backgroundColor: Color,
    onItem: (AccountId) -> Unit,
) {
    item {
        ItemDropDownSecondary(
            number = state.number,
            title = state.title,
            expanded = state.expanded,
            backgroundColor = backgroundColor,
            onClick = { onItem(state.code) }
        )
    }

    if (state.expanded) {
        itemsIndexed(state.syntheticAccounts) { index, accountItem ->
            if (index != 0) Divider()
            ItemDisplay(
                leadingText = accountItem.number,
                mainText = accountItem.title,
                featureText = accountItem.features,
            )
        }
    }
}