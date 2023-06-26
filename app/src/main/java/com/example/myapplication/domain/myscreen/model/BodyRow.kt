package com.example.myapplication.domain.myscreen.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed interface BodyRow : Parcelable {
    val type: BodyRowType
}
