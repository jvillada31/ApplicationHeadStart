package com.example.myapplication.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

enum class TypeResponse {
    Prueba,
    Prueba2
}

sealed interface ServerDrivenResponse {
    val typeResponse: TypeResponse
}

data class Type1Response(
    @Json(name = "action") val action: String? = null,
    @Json(name = "content") val content: ContentResponse? = null
) : ServerDrivenResponse {
    override val typeResponse: TypeResponse = TypeResponse.Prueba
}

data class Type2Response(
    @Json(name = "aha") val aha: String? = null,
    @Json(name = "tuque") val tuque: String? = null
) : ServerDrivenResponse {
    override val typeResponse: TypeResponse = TypeResponse.Prueba2
}

@JsonClass(generateAdapter = true)
data class ContentResponse(
    @Json(name = "title") val title: String? = null
)
