package com.example.myapplication.ui.fetch

import com.example.myapplication.domain.ServerDrivenModel

data class FetchUiState(
    val stringValue: String? = null,
    val serverDrivenValue: ServerDrivenModel? = null,
    val offline: Boolean = false
)
