package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.DoSomething
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val doSomething: DoSomething
) : ViewModel() {

    private var fetchJob: Job? = null

    fun doSomething() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            doSomething.invoke()
                .onSuccess {
                    Timber.d("This is a success")
                }
                .onFailure {
                    Timber.wtf(it, "This is a failure")
                }
        }
    }
}
