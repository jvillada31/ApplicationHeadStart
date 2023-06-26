package com.example.myapplication.domain.myscreen.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Body(
    val title: String,
    val iconUrl: String,
//    val closeAction: Action
) : Parcelable
