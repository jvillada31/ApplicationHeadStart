package com.example.myapplication.domain

import androidx.annotation.CheckResult
import com.example.myapplication.R
import com.example.myapplication.commons.extensions.resultOf
import com.example.myapplication.commons.resources.StringLookup
import validateOrThrow
import javax.inject.Inject

class DoServerDrivenFetch @Inject constructor(
    private val myApplicationRepository: MyApplicationRepository,
    private val stringLookup: StringLookup
) {

    @CheckResult
    suspend operator fun invoke(shouldFail: Boolean): Result<ServerDrivenModel> = resultOf {
        if (shouldFail) {
            throw InputError(stringLookup.getString(R.string.fetch_input_error_message))
        }

        val fetchResult = myApplicationRepository.doServerDrivenFetch()

        validateOrThrow(fetchResult.type.name.isEmpty()) {
            ResultError(stringLookup.getString(R.string.fetch_result_error_message))
        }

        fetchResult
    }
}
