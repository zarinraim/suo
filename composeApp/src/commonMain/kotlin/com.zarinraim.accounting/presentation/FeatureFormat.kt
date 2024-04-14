package com.zarinraim.accounting.presentation

import com.zarinraim.accounting.model.Feature

object FeatureFormat {

    fun format(feature: Feature) = FeatureState(
        label = feature.toLabel(),
        selected = false,
        type = feature,
    )

    private fun Feature.toLabel() = when (this) {
        Feature.Balance -> StringRef.ChartAccount.FeatureBalanceLong
        Feature.OffBalance -> StringRef.ChartAccount.FeatureOffBalanceLong
        Feature.Income -> StringRef.ChartAccount.FeatureIncomeLong
        Feature.Financial -> StringRef.ChartAccount.FeatureFinancialLong
        Feature.Asset -> StringRef.ChartAccount.FeatureAssetLong
        Feature.Liability -> StringRef.ChartAccount.FeatureLiabilityLong
        Feature.TaxExpense -> StringRef.ChartAccount.FeatureTaxExpenseLong
        Feature.NonTaxExpense -> StringRef.ChartAccount.FeatureNonTaxExpenseLong
    }
}