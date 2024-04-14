package com.zarinraim.accounting.data

import accountingchart.composeapp.generated.resources.Res
import com.zarinraim.accounting.data.converter.ChartAccountConverter
import com.zarinraim.accounting.data.dto.ChartAccountDto
import com.zarinraim.accounting.domain.ChartAccountRepository
import com.zarinraim.accounting.model.ChartAccount
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi

class ChartAccountRepositoryImpl : ChartAccountRepository {

    @OptIn(ExperimentalResourceApi::class)
    override suspend fun fetch(): Result<ChartAccount> {
        return kotlin.runCatching {
            val file = Res.readBytes(ChartAccountFilePath).decodeToString()
            Json
                .decodeFromString<ChartAccountDto>(file)
                .let(ChartAccountConverter::toDomain)
        }
    }

    private companion object {

        const val ChartAccountFilePath = "files/chart_accounts.json"
    }
}