package com.example.myapplication.ui.myscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MyScreen() {
    val myScreenViewModel = hiltViewModel<MyScreenViewModel>()
    val uiState = myScreenViewModel.uiState

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = uiState.myScreenModel?.type?.name.orEmpty())
        Text(text = uiState.myScreenModel?.header?.title.orEmpty())
        Text(text = uiState.myScreenModel?.header?.iconUrl.orEmpty())
    }
}
