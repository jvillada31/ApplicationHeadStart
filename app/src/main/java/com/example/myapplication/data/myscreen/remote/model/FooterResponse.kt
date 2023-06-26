package com.example.myapplication.data.myscreen.remote.model

import com.example.myapplication.domain.myscreen.model.Footer

data class FooterResponse(
    val buttonList: List<ButtonResponse>? = null,
)

fun FooterResponse.mapToDomain(): Footer = Footer(
    buttonList = buttonList?.map { it.mapToDomain() } ?: error("buttonList cannot be null")
)
