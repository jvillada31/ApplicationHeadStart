package com.example.myapplication.domain.myscreen.usecases

import androidx.annotation.CheckResult
import com.example.myapplication.R
import com.example.myapplication.commons.extensions.resultOf
import com.example.myapplication.commons.resources.StringLookup
import com.example.myapplication.domain.myscreen.model.MyScreenModel
import com.example.myapplication.domain.myscreen.repository.MyScreenRepository
import validateOrThrow
import javax.inject.Inject

class GetMyScreen @Inject constructor(
    private val myScreenRepository: MyScreenRepository,
    private val stringLookup: StringLookup
) {

    @CheckResult
    suspend operator fun invoke(shouldFail: Boolean): Result<MyScreenModel> = resultOf {
        if (shouldFail) {
            throw InputError(stringLookup.getString(R.string.fetch_input_error_message))
        }

        val fetchResult = myScreenRepository.getMyScreen()

        validateOrThrow(fetchResult.type.name.isNotEmpty()) {
            ResultError(stringLookup.getString(R.string.fetch_result_error_message))
        }

        fetchResult
    }
}

sealed interface DoSomethingError
data class InputError(val errorMessage: String) : DoSomethingError, Exception(errorMessage)
data class ResultError(val errorMessage: String) : DoSomethingError, Exception(errorMessage)
