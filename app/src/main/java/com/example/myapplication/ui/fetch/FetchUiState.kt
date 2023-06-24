package com.example.myapplication.ui.fetch

import com.example.myapplication.domain.myscreen.model.MyScreenModel

data class FetchUiState(
    val myScreenModel: MyScreenModel? = null,
    val offline: Boolean = false
)
