package com.example.myapplication.domain

import androidx.annotation.CheckResult
import com.example.myapplication.commons.extensions.resultOf
import validateOrThrow
import javax.inject.Inject

class DoSomething @Inject constructor(
    private val myApplicationRepository: MyApplicationRepository
) {

    @CheckResult
    suspend operator fun invoke(): Result<String> = resultOf {
        val someResult = myApplicationRepository.doSomething()

        validateOrThrow(someResult.isNotEmpty()) {
            SomeError("Something is empty, this is unexpected, needs to be handled")
        }

        someResult
    }
}

sealed interface DoSomethingError
data class SomeError(val errorMessage: String) : DoSomethingError, Exception(errorMessage)
