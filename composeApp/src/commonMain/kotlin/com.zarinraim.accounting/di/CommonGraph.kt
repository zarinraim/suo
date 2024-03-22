package com.zarinraim.accounting.di

import com.zarinraim.accounting.scene.ChartAccountsViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object CommonGraph {

    val module: Module = module {
        viewModelDefinition { ChartAccountsViewModel() }
    }
}