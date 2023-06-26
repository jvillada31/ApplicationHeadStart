package com.example.myapplication.data.converters

import androidx.room.TypeConverter
import com.example.myapplication.data.myscreen.cache.model.ButtonEntity
import com.example.myapplication.data.myscreen.remote.model.BodyRowResponse
import com.example.myapplication.data.myscreen.remote.model.CrossSellingResponse
import com.example.myapplication.data.myscreen.remote.model.MessageResponse
import com.example.myapplication.data.myscreen.remote.model.SectionResponse
import com.example.myapplication.domain.myscreen.model.BodyRow
import com.example.myapplication.domain.myscreen.model.BodyRowType
import com.example.myapplication.domain.myscreen.model.CrossSelling
import com.example.myapplication.domain.myscreen.model.Message
import com.example.myapplication.domain.myscreen.model.ScreenType
import com.example.myapplication.domain.myscreen.model.Section
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.lang.reflect.ParameterizedType

class MyScreenCacheConverters {

    @TypeConverter
    fun toScreenType(value: String): ScreenType = enumValueOf(value)

    @TypeConverter
    fun fromBodyRowType(value: BodyRowType) = value.name

    @TypeConverter
    fun toBodyRowType(value: String): BodyRowType = enumValueOf(value)

    @TypeConverter
    fun fromScreenType(value: ScreenType) = value.name

    private val bodyRowParametrizedType: ParameterizedType =
        Types.newParameterizedType(List::class.java, BodyRow::class.java)
    private val bodyRowJsonAdapter: JsonAdapter<List<BodyRow>> =
        Moshi.Builder()
            .add(
                PolymorphicJsonAdapterFactory.of(BodyRow::class.java, "type")
                    .withSubtype(CrossSelling::class.java, BodyRowType.CROSS_SELLING.name)
                    .withSubtype(Message::class.java, BodyRowType.MESSAGE.name)
                    .withSubtype(Section::class.java, BodyRowType.SECTION.name)
            )
            .add(KotlinJsonAdapterFactory())
            .build()
            .adapter(bodyRowParametrizedType)

    @TypeConverter
    fun toBodyRowList(value: String?): List<BodyRow>? {
        return if (value != null) bodyRowJsonAdapter.fromJson(value) else null
    }

    @TypeConverter
    fun fromBodyRow(bodyRowList: List<BodyRow>?): String? {
        return bodyRowJsonAdapter.toJson(bodyRowList)
    }

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
}
