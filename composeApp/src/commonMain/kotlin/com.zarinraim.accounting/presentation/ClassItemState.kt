package com.zarinraim.accounting.presentation

data class ClassItemState(
    val number: String,
    val title: String,
    val groupAccounts: List<GroupItemState>
)

data class GroupItemState(
    val number: String,
    val title: String,
    val syntheticAccounts: List<SyntheticItemState>
)

data class SyntheticItemState(
    val number: String,
    val title: String,
)