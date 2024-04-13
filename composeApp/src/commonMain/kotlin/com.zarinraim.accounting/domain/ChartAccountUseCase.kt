package com.zarinraim.accounting.domain

import com.zarinraim.accounting.model.ChartAccount
import com.zarinraim.accounting.utils.UnitUseCase

interface ChartAccountUseCase {

    class Fetch(
        private val repository: ChartAccountRepository,
    ) : UnitUseCase<ChartAccount> {

        override fun invoke(): ChartAccount {
            return repository.fetch()
        }
    }
}