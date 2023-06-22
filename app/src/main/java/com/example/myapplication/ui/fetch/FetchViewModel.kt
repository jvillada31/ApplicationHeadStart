package com.example.myapplication.ui.fetch

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.DoFetch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FetchViewModel @Inject constructor(
    private val doFetch: DoFetch
) : ViewModel() {

    private var fetchJob: Job? = null

    var uiState by mutableStateOf(FetchUiState())
        private set

    fun doFetch(shouldFail: Boolean) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch(Dispatchers.IO) {
            doFetch.invoke(shouldFail)
                .onSuccess { value ->
                    Timber.d("This is a success")
                    uiState = uiState.copy(value = value)
                }
                .onFailure { throwable ->
                    Timber.wtf(throwable, "This is a failure")
                    uiState = uiState.copy(offline = true)
                }
        }
    }
}
