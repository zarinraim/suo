package com.zarinraim.accounting.data.converter

import com.zarinraim.accounting.data.dto.ChartAccountDto
import com.zarinraim.accounting.data.dto.ClassAccountDto
import com.zarinraim.accounting.data.dto.GroupAccountDto
import com.zarinraim.accounting.data.dto.SyntheticAccountDto
import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.ChartAccount
import com.zarinraim.accounting.model.ClassAccount
import com.zarinraim.accounting.model.Feature
import com.zarinraim.accounting.model.GroupAccount
import com.zarinraim.accounting.model.SyntheticAccount

object ChartAccountConverter {

    fun toDomain(external: ChartAccountDto): ChartAccount = ChartAccount(
        classAccounts = external.classAccounts.map { it.toDomain() }
    )

    private fun ClassAccountDto.toDomain(): ClassAccount = ClassAccount(
        id = AccountId(code = id, title = title),
        groupAccounts = groupAccounts.map { it.toDomain() }
    )

    private fun GroupAccountDto.toDomain(): GroupAccount = GroupAccount(
        id = AccountId(code = id, title = title),
        syntheticAccounts = syntheticAccounts.map { it.toDomain() }
    )

    private fun SyntheticAccountDto.toDomain(): SyntheticAccount = SyntheticAccount(
        id = AccountId(code = id, title = title),
        features = features.map { it.toFeature() },
    )

    private fun String.toFeature() = when (this) {
        "R" -> Feature.Balance
        "V" -> Feature.Income
        "A" -> Feature.Asset
        "P" -> Feature.Liability
        "D" -> Feature.TaxExpense
        "N" -> Feature.NonTaxExpense
        "Z" -> Feature.Financial
        "P*" -> Feature.OffBalance
        else -> error("Unknown account feature")
    }
}