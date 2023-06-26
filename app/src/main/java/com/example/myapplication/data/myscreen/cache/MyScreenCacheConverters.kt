package com.example.myapplication.data.myscreen.cache

import androidx.room.TypeConverter
import com.example.myapplication.data.myscreen.cache.model.ButtonEntity
import com.example.myapplication.domain.myscreen.model.ScreenType
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.ParameterizedType

class MyScreenCacheConverters {

    private val buttonParametrizedType: ParameterizedType =
        Types.newParameterizedType(List::class.java, ButtonEntity::class.java)
    private val buttonJsonAdapter: JsonAdapter<List<ButtonEntity>> =
        Moshi.Builder().build().adapter(buttonParametrizedType)

    @TypeConverter
    fun toButtonList(value: String?): List<ButtonEntity>? {
        return if (value != null) buttonJsonAdapter.fromJson(value) else null
    }

    @TypeConverter
    fun fromButtonList(buttonList: List<ButtonEntity>?): String? {
        return buttonJsonAdapter.toJson(buttonList)
    }

    @TypeConverter
    fun toScreenType(value: String): ScreenType = enumValueOf(value)

    @TypeConverter
    fun fromScreenType(value: ScreenType) = value.name
}
