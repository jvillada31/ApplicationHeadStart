package com.example.myapplication.domain.myscreen.model

import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Section(
    val sectionTitle: String
) : BodyRow {

    @IgnoredOnParcel
    override val type: BodyRowType = BodyRowType.SECTION
}
