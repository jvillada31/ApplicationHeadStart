package com.example.myapplication.domain.myscreen.model

import android.os.Parcelable
import androidx.compose.ui.graphics.Color
import kotlinx.parcelize.Parcelize

@Parcelize
enum class ScreenType : Parcelable {
    APPROVED,
    PROCESSING,
    REJECTED;

    fun toColor(): Color = when (this) {
        APPROVED -> Color(0xFF00A650)
        PROCESSING -> Color(0xFFFF7733)
        REJECTED -> Color(0xFFF23D4F)
    }
}
