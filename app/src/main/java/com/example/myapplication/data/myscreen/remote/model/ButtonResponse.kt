package com.example.myapplication.data.myscreen.remote.model

import com.example.myapplication.domain.myscreen.model.Button

data class ButtonResponse(
    val label: String? = null
)

fun ButtonResponse.mapToDomain(): Button = Button(
    label = label ?: error("label cannot be null")
)
