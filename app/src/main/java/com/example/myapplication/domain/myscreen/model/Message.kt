package com.example.myapplication.domain.myscreen.model

import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Message(
    val text: String
) : BodyRow {

    @IgnoredOnParcel
    override val type: BodyRowType = BodyRowType.MESSAGE
}
