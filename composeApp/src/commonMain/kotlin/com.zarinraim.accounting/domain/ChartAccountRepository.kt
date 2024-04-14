package com.zarinraim.accounting.domain

import com.zarinraim.accounting.model.ChartAccount

interface ChartAccountRepository {

    suspend fun fetch(): Result<ChartAccount>
}