package com.example.myapplication.domain

import androidx.annotation.CheckResult
import com.example.myapplication.R
import com.example.myapplication.commons.extensions.resultOf
import com.example.myapplication.commons.resources.StringLookup
import validateOrThrow
import javax.inject.Inject

class DoFetch @Inject constructor(
    private val myApplicationRepository: MyApplicationRepository,
    private val stringLookup: StringLookup
) {

    @CheckResult
    suspend operator fun invoke(shouldFail: Boolean): Result<String> = resultOf {
        if (shouldFail) {
            throw InputError(stringLookup.getString(R.string.fetch_input_error_message))
        }

        val fetchResult = myApplicationRepository.doFetch()

        validateOrThrow(fetchResult.isNotEmpty()) {
            ResultError(stringLookup.getString(R.string.fetch_result_error_message))
        }

        fetchResult
    }
}

sealed interface DoSomethingError
data class InputError(val errorMessage: String) : DoSomethingError, Exception(errorMessage)
data class ResultError(val errorMessage: String) : DoSomethingError, Exception(errorMessage)
