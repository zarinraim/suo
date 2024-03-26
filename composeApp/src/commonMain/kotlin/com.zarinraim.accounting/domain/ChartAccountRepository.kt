package com.zarinraim.accounting.domain

import com.zarinraim.accounting.model.ChartAccount

interface ChartAccountRepository {

    fun fetch(): ChartAccount
}