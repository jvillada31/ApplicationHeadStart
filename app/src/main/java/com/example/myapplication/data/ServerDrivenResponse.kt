package com.example.myapplication.data

import com.example.myapplication.domain.ContentModel
import com.example.myapplication.domain.ServerDrivenModel
import com.example.myapplication.domain.Type1Model
import com.example.myapplication.domain.Type2Model
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

fun ServerDrivenResponse.mapToDomain(): ServerDrivenModel = when (this) {
    is Type1Response -> {
        Type1Model(
            action = this.action.orEmpty(),
            content = this.content?.mapToDomain()
        )
    }

    is Type2Response -> {
        Type2Model(
            aha = this.aha.orEmpty(),
            tuque = this.tuque.orEmpty()
        )
    }
}

fun ContentResponse.mapToDomain(): ContentModel = ContentModel(
    title = this.title.orEmpty()
)
