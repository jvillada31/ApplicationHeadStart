package com.example.myapplication.domain.myscreen.model

import android.os.Parcelable
import com.example.myapplication.data.myscreen.remote.model.ButtonResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class Footer(
    val buttonList: List<Button>
) : Parcelable
