package com.zarinraim.accounting.domain

import com.zarinraim.accounting.model.ChartAccount
import com.zarinraim.accounting.model.ClassAccount
import com.zarinraim.accounting.model.Feature
import com.zarinraim.accounting.model.GroupAccount
import com.zarinraim.accounting.utils.UnitUseCase
import com.zarinraim.accounting.utils.UseCase

interface ChartAccountUseCase {

    class Fetch(
        private val repository: ChartAccountRepository,
    ) : UnitUseCase<ChartAccount> {

        override fun invoke(): ChartAccount {
            return repository.fetch()
        }
    }

    class Filter(
        private val repository: ChartAccountRepository,
    ) : UseCase<Set<Feature>, ChartAccount> {

        override fun invoke(input: Set<Feature>): ChartAccount {
            val data = repository.fetch()
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