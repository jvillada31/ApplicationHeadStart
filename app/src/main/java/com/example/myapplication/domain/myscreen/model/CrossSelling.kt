package com.example.myapplication.domain.myscreen.model

import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class CrossSelling(
    val text: String
) : BodyRow {

    @IgnoredOnParcel
    override val type: BodyRowType = BodyRowType.CROSS_SELLING
}
