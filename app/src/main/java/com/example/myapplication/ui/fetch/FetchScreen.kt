package com.example.myapplication.ui.fetch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.ui.components.NoNetwork

@Composable
fun FetchScreen(
    onClick: (String) -> Unit
) {
    val fetchViewModel = hiltViewModel<FetchViewModel>()
    val uiState = fetchViewModel.uiState

    if (uiState.offline) {
        NoNetwork()
    } else if (uiState.value?.isNotEmpty() == true) {
        onClick(uiState.value)
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { fetchViewModel.doFetch(false) }
            ) {
                Text(text = "Make successful request")
            }
            Button(
                onClick = { fetchViewModel.doFetch(true) }
            ) {
                Text(text = "Make unsuccessful request")
            }
        }
    }
}
