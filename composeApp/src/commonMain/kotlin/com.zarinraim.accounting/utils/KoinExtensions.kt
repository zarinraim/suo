package com.zarinraim.accounting.utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import org.koin.compose.koinInject

@Composable
inline fun <reified T : ViewModel> getViewModel(): T = koinInject()