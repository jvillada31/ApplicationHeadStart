package com.example.myapplication.data.myscreen.remote.model

import com.example.myapplication.domain.myscreen.model.BodyRow
import com.example.myapplication.domain.myscreen.model.BodyRowType
import com.example.myapplication.domain.myscreen.model.Section

data class SectionResponse(
    val sectionTitle: String
) : BodyRowResponse {

    override val type: BodyRowType = BodyRowType.SECTION

    override fun mapToDomain(): BodyRow = Section(
        sectionTitle = sectionTitle
    )
}
