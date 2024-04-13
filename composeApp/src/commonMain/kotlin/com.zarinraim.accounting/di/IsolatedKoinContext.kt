package com.zarinraim.accounting.di

import org.koin.dsl.koinApplication

object IsolatedKoinContext {

    val koinApp = koinApplication {
        modules(CommonGraph.module)
    }
}