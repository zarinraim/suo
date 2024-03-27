package com.zarinraim.accounting.model

data class AccountId(
    val code: String,
    val title: String,
) {

    val classNumber: String
        get() = if (code.length < 0) {
            error("Code should not be empty")
        } else {
            code.substring(0, 1)
        }

    val groupNumber: String?
        get() = if (code.length == 2) {
            code.substring(1, 2)
        } else {
            null
        }

    val syntheticNumber: String?
        get() = if (code.length == 3) {
            code.substring(2, 3)
        } else {
            null
        }
}