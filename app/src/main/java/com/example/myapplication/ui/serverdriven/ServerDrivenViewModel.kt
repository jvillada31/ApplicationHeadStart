package com.example.myapplication.ui.serverdriven

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.ui.NavigationArgument
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ServerDrivenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var fetchJob: Job? = null

    private val serviceDrivenMessage: String? = savedStateHandle[NavigationArgument.MESSAGE]
    var uiState by mutableStateOf(ServerDrivenUiState())
        private set

    init {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch(Dispatchers.IO) {
            // TODO: Get SD UI Model from cache with an ID
            withContext(Dispatchers.Main) {
                uiState = uiState.copy(value = serviceDrivenMessage)
            }
        }
    }
}
