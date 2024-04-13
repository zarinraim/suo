package com.zarinraim.accounting.presentation

import androidx.compose.ui.graphics.Color
import com.zarinraim.accounting.model.AccountId

data class AccountsState(
    val items: List<ClassItemState>,
) {

    fun collapseAll(): AccountsState {
        return copy(items = items.map { classItem ->
            classItem.copy(
                expanded = false,
                groupAccounts = classItem.groupAccounts.map { groupItem -> groupItem.copy(expanded = false) }
            )
        })
    }

    fun toggle(code: AccountId): AccountsState {
        return copy(items = items.map { classItemState -> updateClassExpanded(code, classItemState) })
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
}

data class ClassItemState(
    val code: AccountId,
    val number: String,
    val title: String,
    val expandVisible: Boolean,
    val expanded: Boolean,
    val background: ClassColor,
    val groupAccounts: List<GroupItemState>,
)

data class GroupItemState(
    val code: AccountId,
    val number: String,
    val title: String,
    val expandVisible: Boolean,
    val expanded: Boolean,
    val syntheticAccounts: List<SyntheticItemState>,
)

data class SyntheticItemState(
    val code: AccountId,
    val number: String,
    val title: String,
    val features: String,
    val backroundColor: Color,
)