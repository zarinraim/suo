package com.zarinraim.accounting.data

import com.zarinraim.accounting.domain.ChartRepository
import com.zarinraim.accounting.model.ChartAccount
import com.zarinraim.accounting.model.ChartFilter
import com.zarinraim.accounting.model.ClassAccount
import com.zarinraim.accounting.model.Feature
import com.zarinraim.accounting.model.GroupAccount
import com.zarinraim.accounting.utils.normalize
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

class ChartRepositoryImpl : ChartRepository {

    private val chartAccount = MutableStateFlow<ChartAccount?>(null)
    private val filteredChart = MutableStateFlow<ChartAccount?>(null)
    override fun store(chart: ChartAccount) {
        chartAccount.value = chart
        filteredChart.value = chart
    }

    override fun observe(): Flow<ChartAccount> {
        return filteredChart.filterNotNull()
    }

    override fun applyFilter(filter: ChartFilter) {
        chartAccount.value?.let { chartAccount ->
            filteredChart.value = chartAccount.copy(
                classAccounts = chartAccount.classAccounts.mapNotNull { classAccount ->
                    if (filter.features.isNotEmpty()) {
                        classAccount
                            .filter(features = filter.features)
                            ?.search(query = filter.query)
                    } else {
                        classAccount.search(query = filter.query)
                    }
                }
            )
        }
    }

    override fun reset() {
        filteredChart.value = chartAccount.value
    }

    private fun ClassAccount.search(query: String) = groupAccounts
        .mapNotNull { groupAccount -> groupAccount.search(query) }
        .takeIf { it.isNotEmpty() }
        ?.let { copy(groupAccounts = it) }

    private fun GroupAccount.search(query: String) = syntheticAccounts
        .filter { it.id.code.contains(query) || it.id.title.containsInTitle(query) }
        .takeIf { it.isNotEmpty() }
        ?.let { copy(syntheticAccounts = it) }

    private fun ClassAccount.filter(features: Set<Feature>) = groupAccounts
        .mapNotNull { groupAccount -> groupAccount.filter(features) }
        .takeIf { it.isNotEmpty() }
        ?.let { copy(groupAccounts = it) }

    private fun GroupAccount.filter(features: Set<Feature>) = syntheticAccounts
        .filter { features.all { feature -> feature in it.features } }
        .takeIf { it.isNotEmpty() }
        ?.let { copy(syntheticAccounts = it) }

    private fun String.containsInTitle(other: String) = normalize().contains(other = other, ignoreCase = true)
}