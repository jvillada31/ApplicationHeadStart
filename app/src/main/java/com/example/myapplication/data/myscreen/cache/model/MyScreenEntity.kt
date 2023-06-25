package com.example.myapplication.data.myscreen.cache.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.domain.myscreen.model.MyScreenModel
import com.example.myapplication.domain.myscreen.model.ScreenType

@Entity(tableName = "MyScreen")
data class MyScreenEntity(
    @ColumnInfo(name = "type") val type: ScreenType,
    @Embedded(prefix = "header_") val header: HeaderEntity
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

fun MyScreenEntity.mapToDomain(): MyScreenModel {
    return with(this) {
        MyScreenModel(
            type = type,
            header = header.mapToDomain()
        )
    }
}
