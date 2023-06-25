package com.example.myapplication.data.myscreen.cache

import androidx.room.TypeConverter
import com.example.myapplication.domain.myscreen.model.ScreenType

class MyScreenCacheConverters {

    @TypeConverter
    fun toScreenType(value: String): ScreenType = enumValueOf(value)

    @TypeConverter
    fun fromScreenType(value: ScreenType) = value.name
}
