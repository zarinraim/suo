package com.zarinraim.accounting.model

data class ChartFilter(
    val features: Set<Feature>,
    val query: String,
)