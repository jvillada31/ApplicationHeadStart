package com.example.myapplication.data.myscreen.cache.model

import androidx.room.ColumnInfo
import com.example.myapplication.domain.myscreen.model.Header

data class HeaderEntity(
    var id: Long = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "iconUrl") val iconUrl: String
)

fun HeaderEntity.mapToDomain(): Header {
    return with(this) {
        Header(
            title = title,
            iconUrl = iconUrl
        )
    }
}
