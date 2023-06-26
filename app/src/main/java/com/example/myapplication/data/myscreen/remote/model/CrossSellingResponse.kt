package com.example.myapplication.data.myscreen.remote.model

import com.example.myapplication.domain.myscreen.model.BodyRow
import com.example.myapplication.domain.myscreen.model.BodyRowType
import com.example.myapplication.domain.myscreen.model.CrossSelling

data class CrossSellingResponse(
    val text: String
) : BodyRowResponse {

    override val type: BodyRowType = BodyRowType.CROSS_SELLING

    override fun mapToDomain(): BodyRow = CrossSelling(
        text = text
    )
}
