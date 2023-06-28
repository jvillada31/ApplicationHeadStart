package com.example.myapplication.ui.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.myscreen.model.BodyRow
import com.example.myapplication.domain.myscreen.model.CrossSelling
import com.example.myapplication.domain.myscreen.model.Message
import com.example.myapplication.domain.myscreen.model.Section

@Composable
fun BodySection(
    body: List<BodyRow>?,
    modifier: Modifier = Modifier
) {
    if (body?.isNotEmpty() == true) {
        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            body.map { bodyRow ->
                when (bodyRow) {
                    is CrossSelling -> item {
                        // CrossSelling(...)
                        Text(
                            text = bodyRow.text,
                            color = Color.Black.copy(alpha = 0.9f),
                            textAlign = TextAlign.Center
                        )
                    }

                    is Message -> item {
                        // Message(...)
                        Text(
                            text = bodyRow.text,
                            color = Color.Black.copy(alpha = 0.9f),
                            textAlign = TextAlign.Center
                        )
                    }

                    is Section -> item {
                        // Section(...)
                        Card(
                            modifier = modifier
                                .fillMaxWidth()
                                .shadow(elevation = 16.dp)
                                .defaultMinSize(minHeight = 88.dp),
                            shape = MaterialTheme.shapes.medium,
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            ),
                        ) {
                            Text(
                                text = bodyRow.sectionTitle,
                                color = Color.Black.copy(alpha = 0.9f),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}
