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
import com.example.myapplication.domain.ServerDrivenModel
import com.example.myapplication.ui.components.NoNetwork

@Composable
fun FetchScreen(
    onClick: (String) -> Unit,
    onClickServerDriven: (ServerDrivenModel) -> Unit
) {
    val fetchViewModel = hiltViewModel<FetchViewModel>()
    val uiState = fetchViewModel.uiState

    LaunchedEffect(uiState) {
        if (uiState.stringValue?.isNotEmpty() == true) {
            onClick(uiState.stringValue)
        } else if (uiState.serverDrivenValue != null) {
            onClickServerDriven(uiState.serverDrivenValue)
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
                onClick = { fetchViewModel.doFetch(false) }
            ) {
                Text(text = "Make successful request")
            }
            Button(
                onClick = { fetchViewModel.doServerDrivenFetch(false) }
            ) {
                Text(text = "Make successful SD request")
            }
            Button(
                onClick = { fetchViewModel.doFetch(true) }
            ) {
                Text(text = "Make unsuccessful request")
            }
        }
    }
}
