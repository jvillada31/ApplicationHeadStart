package com.example.myapplication.domain.myscreen.model

import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class SectionModel(
    val sectionTitle: String,
    val bodyRowModel: List<BodyRowModel>
) : BodyRowModel {

    @IgnoredOnParcel
    override val type: BodyRowType = BodyRowType.SECTION
}
