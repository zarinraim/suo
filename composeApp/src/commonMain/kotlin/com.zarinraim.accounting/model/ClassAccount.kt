package com.zarinraim.accounting.model

data class ClassAccount(
    val id: AccountId,
    val groupAccounts: List<GroupAccount>
)