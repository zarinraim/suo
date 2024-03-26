package com.zarinraim.accounting.model

data class SyntheticAccount(
    val id: AccountId,
    val features: List<Feature>
) {

    enum class Feature {
        Balance, OffBalance, Income, Financial,
        Asset, Liability,
        TaxExpense, NonTaxExpense
    }
}