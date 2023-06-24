package com.example.myapplication.data.myscreen.remote.model

import com.example.myapplication.domain.myscreen.model.MyScreenModel
import com.example.myapplication.domain.myscreen.model.ScreenType
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MyScreenResponse(
    val type: ScreenType,
    val header: HeaderResponse? = null
)

fun MyScreenResponse.mapToDomain(): MyScreenModel = MyScreenModel(
    type = this.type,
    header = header?.mapToDomain() ?: error("header cannot be null")
)
