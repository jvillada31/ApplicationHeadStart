package com.example.myapplication.ui.fetch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.ui.components.NoNetwork

@Composable
fun FetchScreen(
    onClick: (Long) -> Unit
) {
    val fetchViewModel = hiltViewModel<FetchViewModel>()
    val uiState = fetchViewModel.uiState

    LaunchedEffect(uiState) {
        when {
            uiState.myScreenIdentifier != null -> onClick(uiState.myScreenIdentifier)
        }

        fetchViewModel.navigationHandled()
    }

    if (uiState.offline) {
        NoNetwork()
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { fetchViewModel.getMyScreen(false) }
            ) {
                Text(text = "Make successful MyScreen request")
            }
            Button(
                onClick = { fetchViewModel.getMyScreen(true) }
            ) {
                Text(text = "Make unsuccessful MyScreen request")
            }
        }
    }
}
