package com.example.myapplication.ui.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplication.domain.myscreen.model.Button

@Composable
fun FooterSection(
    buttonList: List<Button>?,
    modifier: Modifier,
    onClick: () -> Unit
) {
    if (buttonList?.isNotEmpty() == true) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            buttonList.map { button ->
                Button(
                    onClick = { onClick.invoke() }
                ) {
                    Text(text = button.label)
                }
            }
        }
    }
}
