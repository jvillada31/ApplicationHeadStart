package com.example.myapplication.data

import com.example.myapplication.domain.ContentModel
import com.example.myapplication.domain.ServerDrivenModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ServerDrivenResponse(
    @Json(name = "type") val type: String? = null,
    @Json(name = "action") val action: String? = null,
    @Json(name = "content") val content: ContentResponse? = null
)

@JsonClass(generateAdapter = true)
data class ContentResponse(
    @Json(name = "title") val title: String? = null
)

fun ServerDrivenResponse.mapToDomain() = ServerDrivenModel(
    content = content?.mapToDomain()
)

fun ContentResponse.mapToDomain() = ContentModel(
    title = this.title.orEmpty()
)
