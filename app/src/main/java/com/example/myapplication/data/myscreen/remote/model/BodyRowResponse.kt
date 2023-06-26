package com.example.myapplication.data.myscreen.remote.model

import com.example.myapplication.domain.myscreen.model.BodyRow
import com.example.myapplication.domain.myscreen.model.BodyRowType

sealed interface BodyRowResponse {
    val type: BodyRowType

    fun mapToDomain(): BodyRow
}
