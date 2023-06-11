package com.example.myapplication.data

import com.example.myapplication.commons.extensions.resultOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class MyApplicationRemoteDataSource @Inject constructor(
    private val myApplicationApi: MyApplicationApi
) {

    suspend fun doSomething(): Result<String> = resultOf {
        val response = withContext(Dispatchers.IO) {
            myApplicationApi.doSomething()
        }

        val body = response.body()

        if (response.isSuccessful && body != null) {
            body
        } else {
            Timber.d("The retrieved response is not successful and/or body is empty")
            error("The retrieved response is not successful and/or body is empty")
        }
    }
}
