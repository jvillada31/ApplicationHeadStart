package com.example.myapplication.ui.sections

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.domain.myscreen.model.BodyRow
import com.example.myapplication.domain.myscreen.model.CrossSelling
import com.example.myapplication.domain.myscreen.model.Message
import com.example.myapplication.domain.myscreen.model.Section

@Composable
fun BodySection(
    body: List<BodyRow>?,
    modifier: Modifier
) {
    if (body?.isNotEmpty() == true) {
        LazyColumn(
            modifier = modifier
        ) {
            body.map { bodyRow ->
                when (bodyRow) {
                    is CrossSelling -> item {
                        Text(
                            text = bodyRow.text
                        )
                    }

                    is Message -> item {
                        Text(
                            text = bodyRow.text
                        )
                    }

                    is Section -> item {
                        Text(
                            text = bodyRow.sectionTitle
                        )
                    }
                }
            }
        }
    }
}
