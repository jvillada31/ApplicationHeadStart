package com.example.myapplication.domain

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ServerDrivenModel(
    val content: ContentModel? = null
)

@JsonClass(generateAdapter = true)
data class ContentModel(
    val title: String
)
