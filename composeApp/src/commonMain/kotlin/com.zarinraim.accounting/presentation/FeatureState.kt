package com.zarinraim.accounting.presentation

import com.zarinraim.accounting.model.Feature

data class FeatureState(
    val label: String,
    val selected: Boolean,
    val type: Feature,
)