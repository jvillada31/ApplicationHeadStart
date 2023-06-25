package com.example.myapplication.ui.myscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.myscreen.usecases.GetMyScreen
import com.example.myapplication.ui.NavigationArgument
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MyScreenViewModel @Inject constructor(
    private val getMyScreen: GetMyScreen,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var fetchJob: Job? = null

    private val myScreenIdentifier: Long? = savedStateHandle[NavigationArgument.ID]
    var uiState by mutableStateOf(MyScreenUiState())
        private set

    init {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch(Dispatchers.IO) {
            myScreenIdentifier?.let { id ->
                getMyScreen.invoke(id)
                    .onSuccess { myScreenModel ->
                        Timber.d("This is a success")
                        withContext(Dispatchers.Main) {
                            uiState = uiState.copy(myScreenModel = myScreenModel)
                        }
                    }
                    .onFailure { throwable ->
                        Timber.wtf(throwable, "This is a failure")
                    }
            }
        }
    }
}
