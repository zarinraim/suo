package com.zarinraim.accounting.presentation

import com.zarinraim.accounting.model.Feature

object FeatureFormat {

    fun format(feature: Feature) = FeatureState(
        label = feature.toLabel(),
        selected = false,
        type = feature,
    )

    private fun Feature.toLabel() = when (this) {
        Feature.Balance -> "rozvahový"
        Feature.OffBalance -> "podrozvahový"
        Feature.Income -> "výsledkový"
        Feature.Financial -> "závěrkový"
        Feature.Asset -> "aktivní"
        Feature.Liability -> "pasivní"
        Feature.TaxExpense -> "daňový"
        Feature.NonTaxExpense -> "nedaňový"
    }
}