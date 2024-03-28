package com.zarinraim.accounting.scene

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.presentation.ClassItemState
import com.zarinraim.accounting.presentation.GroupItemState
import com.zarinraim.accounting.presentation.SyntheticItemState
import com.zarinraim.accounting.scene.ChartAccountsViewModel.State
import com.zarinraim.accounting.scene.component.Divider
import com.zarinraim.accounting.scene.component.ItemDisplay
import com.zarinraim.accounting.scene.component.ItemDropDownPrimary
import com.zarinraim.accounting.scene.component.ItemDropDownSecondary
import com.zarinraim.accounting.scene.component.VerticalSpacer
import com.zarinraim.accounting.utils.getViewModel

@Composable
fun ChartAccountsScreen(viewModel: ChartAccountsViewModel = getViewModel()) {
    val state = viewModel.states.collectAsState().value

    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        item { SearchBar(state = state, onChange = viewModel::onQueryChange, onClear = viewModel::onQueryClear) }

        when {
            state.searchQuery.isNotEmpty() -> searchResults(state)
            else -> accounts(state = state, onAccount = viewModel::onAccount)
        }

        item { VerticalSpacer(16.dp) }
    }
}

private fun LazyListScope.accounts(
    state: State,
    onAccount: (AccountId) -> Unit,
) {
    state.accounts.forEachIndexed { index, classItem ->
        if (index != 0) item { VerticalSpacer(8.dp) }
        classItem(
            state = classItem,
            onAccount = onAccount,
        )
    }
}

private fun LazyListScope.searchResults(
    state: State,
) {
    when {
        state.filteredAccounts.isEmpty() -> emptyState()
        else -> syntheticAccounts(state.filteredAccounts)
    }
}

private fun LazyListScope.emptyState() {
    item {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text("Žádné výsledky")
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
private fun LazyListScope.classItem(
    state: ClassItemState,
    onAccount: (AccountId) -> Unit,
) {
    stickyHeader {
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

@OptIn(ExperimentalFoundationApi::class)
private fun LazyListScope.groupItem(
    state: GroupItemState,
    backgroundColor: Color,
    onItem: (AccountId) -> Unit,
) {
    stickyHeader {
        ItemDropDownSecondary(
            number = state.number,
            title = state.title,
            expanded = state.expanded,
            backgroundColor = backgroundColor,
            onClick = { onItem(state.code) }
        )
    }

    if (state.expanded) syntheticAccounts(state.syntheticAccounts)
}

private fun LazyListScope.syntheticAccounts(state: List<SyntheticItemState>) {
    itemsIndexed(state) { index, accountItem ->
        if (index != 0) Divider()
        ItemDisplay(
            leadingText = accountItem.number,
            mainText = accountItem.title,
            featureText = accountItem.features,
        )
    }
}

@Composable
private fun SearchBar(state: State, onChange: (String) -> Unit, onClear: () -> Unit) {
    val focusManager = LocalFocusManager.current
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.padding(all = 16.dp)
    ) {
        OutlinedTextField(
            value = state.searchQuery,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Vyhledat") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { focusManager.clearFocus() }),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(color = 0xffe79a3d),
                cursorColor = Color(color = 0xffe79a3d)
            ),
            trailingIcon = if (state.searchQuery.isNotEmpty()) @Composable {
                {
                    IconButton(onClick = { onClear() }) {
                        Icon(Icons.Default.Clear, "")
                    }
                }
            } else {
                null
            },
            onValueChange = onChange,
        )
    }
}