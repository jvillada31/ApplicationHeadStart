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
        val result = myApplicationRepository.doSomething()

        validateOrThrow(result.isNotEmpty()) {
            SomeError("Something is empty, this is unexpected, needs to be handled")
        }

        result
    }
}

sealed interface DoSomethingError
data class SomeError(val errorMessage: String) : DoSomethingError, Exception(errorMessage)
