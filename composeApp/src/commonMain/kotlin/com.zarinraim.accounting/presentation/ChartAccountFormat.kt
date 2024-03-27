package com.zarinraim.accounting.presentation

import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.ClassAccount
import com.zarinraim.accounting.model.GroupAccount
import com.zarinraim.accounting.model.SyntheticAccount

object ChartAccountFormat {

    fun format(classAccounts: List<ClassAccount>): List<ClassItemState> {
        return classAccounts.map { it.format() }
    }

    private fun ClassAccount.format() = ClassItemState(
        code = id,
        number = id.code,
        title = id.title,
        expanded = false,
        background = id.toColor(),
        groupAccounts = groupAccounts.map { it.format() }
    )

    private fun GroupAccount.format() = GroupItemState(
        code = id,
        number = id.code,
        title = id.title,
        expanded = false,
        syntheticAccounts = syntheticAccounts.map { it.format() }
    )

    private fun SyntheticAccount.format() = SyntheticItemState(
        code = id,
        number = id.code,
        title = id.title,
        features = features.format()
    )

    private fun List<SyntheticAccount.Feature>.format(): String {
        val features = map { it.toText() }
        return features.joinToString("\t\t\t")
    }

    private fun SyntheticAccount.Feature.toText(): String = when (this) {
        SyntheticAccount.Feature.Balance -> "R"
        SyntheticAccount.Feature.OffBalance -> "P*"
        SyntheticAccount.Feature.Income -> "V"
        SyntheticAccount.Feature.Financial -> "Z"
        SyntheticAccount.Feature.Asset -> "A"
        SyntheticAccount.Feature.Liability -> "P"
        SyntheticAccount.Feature.TaxExpense -> "D"
        SyntheticAccount.Feature.NonTaxExpense -> "N"
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