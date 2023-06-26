package com.example.myapplication.data.myscreen.cache.model

import androidx.room.ColumnInfo
import com.example.myapplication.domain.myscreen.model.Footer

data class FooterEntity(
    @ColumnInfo(name = "buttonList") val buttonList: List<ButtonEntity>
)

fun FooterEntity.mapToDomain(): Footer {
    return with(this) {
        Footer(
            buttonList = buttonList.map { it.mapToDomain() }
        )
    }
}

fun Footer.mapToCache(): FooterEntity {
    return with(this) {
        FooterEntity(
            buttonList = buttonList.map { it.mapToCache() }
        )
    }
}
