package com.zarinraim.accounting.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ChartAccountDto(
    val classAccounts: List<ClassAccountDto>
)

@Serializable
data class ClassAccountDto(
    val id: String,
    val title: String,
    val groupAccounts: List<GroupAccountDto>
)

@Serializable
data class GroupAccountDto(
    val id: String,
    val title: String,
    val syntheticAccounts: List<SyntheticAccountDto>
)

@Serializable
data class SyntheticAccountDto(
    val id: String,
    val title: String,
    val features: List<String>
)