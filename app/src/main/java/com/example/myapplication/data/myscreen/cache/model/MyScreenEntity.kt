package com.example.myapplication.data.myscreen.cache.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.domain.myscreen.model.MyScreenModel
import com.example.myapplication.domain.myscreen.model.ScreenType

@Entity(tableName = "MyScreen")
data class MyScreenEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0,
    @ColumnInfo(name = "type") val type: ScreenType,
    @Embedded(prefix = "header_") val header: HeaderEntity
)

fun MyScreenEntity.mapToDomain(): MyScreenModel {
    return with(this) {
        MyScreenModel(
            id = id,
            type = type,
            header = header.mapToDomain()
        )
    }
}

fun MyScreenModel.mapToCache(): MyScreenEntity {
    return with(this) {
        MyScreenEntity(
            type = type,
            header = header.mapToCache()
        )
    }
}
