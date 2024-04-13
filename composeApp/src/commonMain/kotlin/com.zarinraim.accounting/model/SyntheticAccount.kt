package com.zarinraim.accounting.model

data class SyntheticAccount(
    val id: AccountId,
    val features: List<Feature>
)