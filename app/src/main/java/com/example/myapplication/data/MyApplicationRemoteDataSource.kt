package com.example.myapplication.data

import com.example.myapplication.commons.extensions.resultOf
import com.example.myapplication.domain.ServerDrivenModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class MyApplicationRemoteDataSource @Inject constructor(
    private val myApplicationApi: MyApplicationApi
) {

    suspend fun doFetch(): Result<String> = resultOf {
        val response = withContext(Dispatchers.IO) {
            myApplicationApi.doFetch()
        }

        val body = response.body()

        if (response.isSuccessful && body != null) {
            body
        } else {
            Timber.d("The retrieved response is not successful and/or body is empty")
            error("The retrieved response is not successful and/or body is empty")
        }
    }

    suspend fun doServerDrivenFetch(): Result<ServerDrivenModel> = resultOf {
        val response = withContext(Dispatchers.IO) {
            myApplicationApi.doServerDrivenFetch()
        }

        val body = response.body()

        if (response.isSuccessful && body != null) {
            body.mapToDomain()
        } else {
            Timber.d("The retrieved response is not successful and/or body is empty")
            error("The retrieved response is not successful and/or body is empty")
        }
    }
}
