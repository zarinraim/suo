package com.zarinraim.accounting.scene

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FilterChip
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.presentation.ClassColor
import com.zarinraim.accounting.presentation.ClassItemState
import com.zarinraim.accounting.presentation.FeatureState
import com.zarinraim.accounting.presentation.GroupItemState
import com.zarinraim.accounting.presentation.StringRef
import com.zarinraim.accounting.presentation.SyntheticItemState
import com.zarinraim.accounting.scene.ChartAccountsViewModel.State
import com.zarinraim.accounting.scene.component.Divider
import com.zarinraim.accounting.scene.component.HorizontalSpacer
import com.zarinraim.accounting.scene.component.ItemDisplay
import com.zarinraim.accounting.scene.component.ItemDropDownPrimary
import com.zarinraim.accounting.scene.component.ItemDropDownSecondary
import com.zarinraim.accounting.scene.component.VerticalSpacer
import com.zarinraim.accounting.utils.getViewModel
import kotlinx.coroutines.launch

@Composable
fun ChartAccountsScreen(viewModel: ChartAccountsViewModel = getViewModel()) {
    Screen(
        state = viewModel.states.collectAsState().value,
        onAccount = viewModel::onAccount,
        onQueryChange = viewModel::onQueryChange,
        onRefresh = viewModel::onRefresh,
        onFeature = viewModel::onFeature
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Screen(
    state: State,
    onAccount: (AccountId) -> Unit,
    onQueryChange: (String) -> Unit,
    onRefresh: () -> Unit,
    onFeature: (FeatureState) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContent = { FilterBottomSheet(state = state, onFeature = onFeature) },
        sheetState = sheetState,
        content = {
            Scaffold(
                topBar = {
                    SearchBar(
                        state = state,
                        focusManager = focusManager,
                        onChange = onQueryChange,
                        onFilter = { coroutineScope.launch { sheetState.show() } }
                    )
                },
                content = { innerPadding ->
                    Content(
                        state = state,
                        innerPadding = innerPadding,
                        onAccount = onAccount,
                    )
                },
                floatingActionButton = { FloatingButton(focusManager = focusManager, onRefresh = onRefresh) }
            )
        }
    )
}

@Composable
private fun Content(
    state: State,
    innerPadding: PaddingValues,
    onAccount: (AccountId) -> Unit,
) {
    LazyColumn(modifier = Modifier.padding(innerPadding).fillMaxHeight()) {
        item { VerticalSpacer() }
        when {
             state.searchQuery.isNotEmpty() -> searchResults(state, onAccount)
            else -> accounts(state = state, onAccount = onAccount)
        }

        item { VerticalSpacer(80.dp) }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalLayoutApi::class)
@Composable
private fun FilterBottomSheet(
    state: State,
    onFeature: (FeatureState) -> Unit
) {
    VerticalSpacer()
    Box(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
    ) {
        Text(text = StringRef.ChartAccount.FilterAccountsTitle, style = MaterialTheme.typography.h6)
    }
    FlowRow(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(space = 4.dp, alignment = Alignment.CenterHorizontally),
    ) {
        state.features.forEach {
            FilterChip(
                selected = it.selected, onClick = { onFeature(it) },
                content = {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = it.label, fontSize = 16.sp)
                    }
                },
                leadingIcon = if (it.selected) {
                    {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Check icon",
                            modifier = Modifier.size(ChipDefaults.LeadingIconSize)
                        )
                    }
                } else {
                    null
                },
            )
        }
    }
    VerticalSpacer()
}

private fun LazyListScope.accounts(
    state: State,
    onAccount: (AccountId) -> Unit,
) {
    state.accounts.items.forEachIndexed { index, classItem ->
        if (index != 0) item { VerticalSpacer(8.dp) }
        classItem(
            state = classItem,
            onAccount = onAccount,
        )
    }
}

private fun LazyListScope.searchResults(
    state: State,
    onAccount: (AccountId) -> Unit,
) {
    when {
        state.accounts.items.isEmpty() -> emptyState()
        else -> accounts(state = state, onAccount = onAccount)
    }
}

private fun LazyListScope.emptyState() {
    item {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text(StringRef.ChartAccount.SearchNoResultsText)
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

    if (state.expanded) syntheticAccounts(state.syntheticAccounts)
}

private fun LazyListScope.syntheticAccounts(state: List<SyntheticItemState>) {
    itemsIndexed(state) { index, accountItem ->
        if (index != 0) Divider()
        ItemDisplay(
            leadingText = accountItem.number,
            mainText = accountItem.title,
            featureText = accountItem.features,
            backgroundColor = accountItem.backroundColor
        )
    }
}

@Composable
private fun SearchBar(state: State, focusManager: FocusManager, onChange: (String) -> Unit, onFilter: () -> Unit) {
    Surface(elevation = 8.dp) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center,
            ) {
                OutlinedTextField(
                    value = state.searchQuery,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(StringRef.ChartAccount.SearchBarPlaceholderText) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = { focusManager.clearFocus() }),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(color = 0xffe79a3d),
                        cursorColor = Color(color = 0xffe79a3d)
                    ),
                    onValueChange = onChange,
                )
            }
            HorizontalSpacer(8.dp)
            IconButton(onClick = onFilter) {
                Icon(imageVector = Icons.Default.Build, contentDescription = "Build icon")
            }
        }
    }
}

@Composable
private fun FloatingButton(focusManager: FocusManager, onRefresh: () -> Unit) {
    FloatingActionButton(
        onClick = {
            focusManager.clearFocus()
            onRefresh()
        },
        modifier = Modifier.size(64.dp),
        backgroundColor = ClassColor.Class0.secondaryColor
    ) {
        Icon(imageVector = Icons.Default.Refresh, contentDescription = "")
    }
}