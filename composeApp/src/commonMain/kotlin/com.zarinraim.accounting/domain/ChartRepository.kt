package com.zarinraim.accounting.domain

import com.zarinraim.accounting.model.ChartAccount
import com.zarinraim.accounting.model.ChartFilter
import kotlinx.coroutines.flow.Flow

interface ChartRepository {

    fun store(chart: ChartAccount)
    fun observe(): Flow<ChartAccount>
    fun applyFilter(filter: ChartFilter)
    fun reset()
}