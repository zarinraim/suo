package com.zarinraim.accounting.di

import com.zarinraim.accounting.data.ChartAccountRepositoryImpl
import com.zarinraim.accounting.data.ChartRepositoryImpl
import com.zarinraim.accounting.domain.ChartAccountRepository
import com.zarinraim.accounting.domain.ChartAccountUseCase
import com.zarinraim.accounting.domain.ChartRepository
import com.zarinraim.accounting.scene.ChartAccountsViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.new
import org.koin.dsl.module

object CommonGraph {

    val module: Module = module {

        single<ChartAccountRepository> { new(::ChartAccountRepositoryImpl) }
        single<ChartRepository> { new(::ChartRepositoryImpl) }

        factoryOf(ChartAccountUseCase::Fetch)
        factoryOf(ChartAccountUseCase::Observe)
        factoryOf(ChartAccountUseCase::ApplyFilter)
        factoryOf(ChartAccountUseCase::ResetFilter)

        viewModelDefinition { new(::ChartAccountsViewModel) }
    }
}