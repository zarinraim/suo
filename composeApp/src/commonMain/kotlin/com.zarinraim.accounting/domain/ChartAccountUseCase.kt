package com.zarinraim.accounting.domain

import com.zarinraim.accounting.model.ChartAccount
import com.zarinraim.accounting.model.ChartFilter
import com.zarinraim.accounting.utils.SuspendUnitUseCase
import com.zarinraim.accounting.utils.UnitUseCase
import com.zarinraim.accounting.utils.UseCase
import kotlinx.coroutines.flow.Flow

interface ChartAccountUseCase {

    class Fetch(
        private val repository: ChartAccountRepository,
        private val chartRepository: ChartRepository,
    ) : SuspendUnitUseCase<Unit> {

        override suspend fun invoke() {
            repository.fetch().onSuccess { chartRepository.store(it) }
        }
    }

    class Observe(
        private val chartRepository: ChartRepository,
    ) : UnitUseCase<Flow<ChartAccount>> {

        override fun invoke(): Flow<ChartAccount> {
            return chartRepository.observe()
        }
    }

    class ApplyFilter(
        private val chartRepository: ChartRepository,
    ) : UseCase<ChartFilter, Unit> {

        override fun invoke(input: ChartFilter) {
            chartRepository.applyFilter(input)
        }
    }

    class ResetFilter(
        private val chartRepository: ChartRepository,
    ) : UnitUseCase<Unit> {

        override fun invoke() {
            chartRepository.reset()
        }
    }
}