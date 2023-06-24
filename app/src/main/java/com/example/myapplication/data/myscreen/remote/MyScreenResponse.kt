package com.example.myapplication.data.myscreen.remote

import com.example.myapplication.domain.myscreen.model.MyScreenModel
import com.example.myapplication.domain.myscreen.model.ScreenType
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MyScreenResponse(
    val type: ScreenType
)

fun MyScreenResponse.mapToDomain(): MyScreenModel = MyScreenModel(
    type = this.type
)
