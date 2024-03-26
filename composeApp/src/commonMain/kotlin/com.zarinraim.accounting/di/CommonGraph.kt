package com.zarinraim.accounting.di

import com.zarinraim.accounting.data.ChartAccountRepositoryImpl
import com.zarinraim.accounting.domain.ChartAccountRepository
import com.zarinraim.accounting.scene.ChartAccountsViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.new
import org.koin.dsl.module

object CommonGraph {

    val module: Module = module {

        single<ChartAccountRepository> { new(::ChartAccountRepositoryImpl) }

        viewModelDefinition { ChartAccountsViewModel(get()) }
    }
}