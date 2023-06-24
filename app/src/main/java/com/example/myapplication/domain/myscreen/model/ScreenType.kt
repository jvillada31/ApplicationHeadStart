package com.example.myapplication.domain.myscreen.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class ScreenType : Parcelable {
    APPROVED,
    PROCESSING,
    REJECTED
}
