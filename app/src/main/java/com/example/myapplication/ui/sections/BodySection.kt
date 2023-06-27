package com.example.myapplication.ui.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            body.map { bodyRow ->
                when (bodyRow) {
                    is CrossSelling -> item {
                        // CrossSelling(...)
                        Text(
                            text = bodyRow.text, textAlign = TextAlign.Center, modifier = Modifier.width(150.dp)
                        )
                    }

                    is Message -> item {
                        // Message(...)
                        Text(
                            text = bodyRow.text, textAlign = TextAlign.Center, modifier = Modifier.width(150.dp)
                        )
                    }

                    is Section -> item {
                        // Section(...)
                        Text(
                            text = bodyRow.sectionTitle, textAlign = TextAlign.Center, modifier = Modifier.width(150.dp)
                        )
                    }
                }
            }
        }
    }
}
