package com.example.myapplication.data.myscreen.cache.model

import androidx.room.ColumnInfo
import com.example.myapplication.domain.myscreen.model.Button
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ButtonEntity(
    @ColumnInfo(name = "label") val label: String
)

fun ButtonEntity.mapToDomain(): Button {
    return with(this) {
        Button(
            label = label
        )
    }
}

fun Button.mapToCache(): ButtonEntity {
    return with(this) {
        ButtonEntity(
            label = label
        )
    }
}
