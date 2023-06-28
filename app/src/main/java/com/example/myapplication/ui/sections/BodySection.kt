package com.example.myapplication.ui.sections

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.domain.myscreen.model.BodyRowModel
import com.example.myapplication.ui.components.bodyrows.BodyModelMapper

@Composable
fun BodySection(
    body: List<BodyRowModel>?,
    modifier: Modifier = Modifier
) {
    if (body?.isNotEmpty() == true) {
        BodyModelMapper(
            bodyRowModel = body,
            modifier = modifier
        )
    }
}
