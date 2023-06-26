package com.example.myapplication.data.myscreen.remote.model

import com.example.myapplication.domain.myscreen.model.BodyRow
import com.example.myapplication.domain.myscreen.model.BodyRowType
import com.example.myapplication.domain.myscreen.model.Message

data class MessageResponse(
    val text: String
) : BodyRowResponse {

    override val type: BodyRowType = BodyRowType.MESSAGE

    override fun mapToDomain(): BodyRow = Message(
        text = text
    )
}
