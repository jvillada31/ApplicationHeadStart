package com.example.myapplication.domain.myscreen.model

data class MyScreenModel(
    val type: ScreenType
)

enum class ScreenType {
    APPROVED,
    PROCESSING,
    REJECTED
}
