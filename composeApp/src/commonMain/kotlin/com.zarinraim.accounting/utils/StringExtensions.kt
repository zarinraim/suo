package com.zarinraim.accounting.utils

fun String.normalize(): String {
    val original = arrayOf("á", "č", "ď", "é", "ě", "í", "ň", "ó", "ř", "š", "ť", "ú", "ů", "ý", "ž")
    val normalized = arrayOf("a", "c", "d", "e", "e", "i", "n", "o", "r", "s", "t", "u", "u", "y", "z")

    return this.map {
        val index = original.indexOf(it.lowercase())
        if (index >= 0) normalized[index] else it
    }.joinToString("")
}