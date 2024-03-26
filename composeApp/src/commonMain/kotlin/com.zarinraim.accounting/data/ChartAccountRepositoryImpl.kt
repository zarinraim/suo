package com.zarinraim.accounting.data

import com.zarinraim.accounting.domain.ChartAccountRepository
import com.zarinraim.accounting.model.ChartAccount

class ChartAccountRepositoryImpl : ChartAccountRepository {

    override fun fetch(): ChartAccount {
        return ChartAccounts.data
    }
}