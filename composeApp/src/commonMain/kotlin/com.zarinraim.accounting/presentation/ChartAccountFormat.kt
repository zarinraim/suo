package com.zarinraim.accounting.presentation

import androidx.compose.ui.graphics.Color
import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.ClassAccount
import com.zarinraim.accounting.model.Feature
import com.zarinraim.accounting.model.GroupAccount
import com.zarinraim.accounting.model.SyntheticAccount

object ChartAccountFormat {

    fun format(classAccounts: List<ClassAccount>, expandDefault: Boolean): AccountsState {
        return AccountsState(
            items = classAccounts.map { it.format(expandDefault) }
        )
    }

    private fun format(syntheticAccount: SyntheticAccount, useColorBackground: Boolean = false): SyntheticItemState = SyntheticItemState(
        code = syntheticAccount.id,
        number = syntheticAccount.id.code,
        title = syntheticAccount.id.title,
        features = syntheticAccount.features.format(),
        backroundColor = if (useColorBackground) syntheticAccount.id.toColor().secondaryColor else Color.Transparent
    )

    private fun ClassAccount.format(expandDefault: Boolean): ClassItemState = ClassItemState(
        code = id,
        number = id.code,
        title = id.title,
        expanded = expandDefault,
        expandVisible = !expandDefault,
        background = id.toColor(),
        groupAccounts = groupAccounts.map { it.format(expandDefault) }
    )

    private fun GroupAccount.format(expandDefault: Boolean): GroupItemState = GroupItemState(
        code = id,
        number = id.code,
        title = id.title,
        expanded = expandDefault,
        expandVisible = !expandDefault,
        syntheticAccounts = syntheticAccounts.map(::format)
    )

    private fun List<Feature>.format(): String {
        val features = map { it.toText() }
        return features.joinToString("\t\t\t")
    }

    private fun Feature.toText(): String = when (this) {
        Feature.Balance -> StringRef.ChartAccount.FeatureBalanceShort
        Feature.OffBalance -> StringRef.ChartAccount.FeatureOffBalanceShort
        Feature.Income -> StringRef.ChartAccount.FeatureIncomeShort
        Feature.Financial -> StringRef.ChartAccount.FeatureFinancialShort
        Feature.Asset -> StringRef.ChartAccount.FeatureAssetShort
        Feature.Liability -> StringRef.ChartAccount.FeatureLiabilityShort
        Feature.TaxExpense -> StringRef.ChartAccount.FeatureTaxExpenseShort
        Feature.NonTaxExpense -> StringRef.ChartAccount.FeatureNonTaxExpenseShort
    }

    private fun AccountId.toColor(): ClassColor {
        return when (classNumber) {
            "0" -> ClassColor.Class0
            "1" -> ClassColor.Class1
            "2" -> ClassColor.Class2
            "3" -> ClassColor.Class3
            "4" -> ClassColor.Class4
            "5" -> ClassColor.Class5
            "6" -> ClassColor.Class6
            "7" -> ClassColor.Class7
            else -> ClassColor.Unspecified
        }
    }
}