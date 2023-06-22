package com.example.myapplication.domain

enum class Type {
    Prueba,
    Prueba2
}

sealed interface ServerDrivenModel {
    val type: Type
}

data class Type1Model(
    val action: String,
    val content: ContentModel?
) : ServerDrivenModel {
    override val type: Type = Type.Prueba
}

data class Type2Model(
    val aha: String,
    val tuque: String
) : ServerDrivenModel {
    override val type: Type = Type.Prueba2
}

data class ContentModel(
    val title: String
)
