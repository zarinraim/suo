package com.zarinraim.accounting.presentation

import com.zarinraim.accounting.model.AccountId

data class ClassItemState(
    val code: AccountId,
    val number: String,
    val title: String,
    val expanded: Boolean,
    val background: ClassColor,
    val groupAccounts: List<GroupItemState>
)

data class GroupItemState(
    val code: AccountId,
    val number: String,
    val title: String,
    val expanded: Boolean,
    val syntheticAccounts: List<SyntheticItemState>
)

data class SyntheticItemState(
    val code: AccountId,
    val number: String,
    val title: String,
    val features: String
)