package com.zarinraim.accounting.domain

import com.zarinraim.accounting.model.ChartAccount
import com.zarinraim.accounting.model.ClassAccount
import com.zarinraim.accounting.model.Feature
import com.zarinraim.accounting.model.GroupAccount
import com.zarinraim.accounting.utils.SuspendUnitUseCase
import com.zarinraim.accounting.utils.SuspendUseCase

interface ChartAccountUseCase {

    class Fetch(
        private val repository: ChartAccountRepository,
    ) : SuspendUnitUseCase<ChartAccount> {

        override suspend fun invoke(): ChartAccount {
            return repository.fetch().fold(
                onSuccess = { it },
                onFailure = { ChartAccount(classAccounts = emptyList()) }
            )
        }
    }

    class Filter(
        private val repository: ChartAccountRepository,
    ) : SuspendUseCase<Set<Feature>, ChartAccount> {

        override suspend fun invoke(input: Set<Feature>): ChartAccount {
            val data = repository.fetch().fold(
                onSuccess = { it },
                onFailure = { ChartAccount(classAccounts = emptyList()) }
            )
            return ChartAccount(classAccounts = data.classAccounts.mapNotNull { classAccount -> classAccount.filter(input) })
        }

        private fun ClassAccount.filter(feature: Set<Feature>) = groupAccounts
            .mapNotNull { groupAccount -> groupAccount.filter(feature) }
            .takeIf { it.isNotEmpty() }
            ?.let { copy(groupAccounts = it) }

        private fun GroupAccount.filter(features: Set<Feature>) = syntheticAccounts
            .filter { features.all { feature -> feature in it.features } }
            .takeIf { it.isNotEmpty() }
            ?.let { copy(syntheticAccounts = it) }
    }
}