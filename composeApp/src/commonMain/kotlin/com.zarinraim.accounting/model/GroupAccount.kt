package com.zarinraim.accounting.model

data class GroupAccount(
    val id: AccountId,
    val syntheticAccounts: List<SyntheticAccount>
)