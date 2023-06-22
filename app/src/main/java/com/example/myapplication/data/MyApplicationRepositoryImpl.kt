package com.example.myapplication.data

import com.example.myapplication.domain.MyApplicationRepository
import com.example.myapplication.domain.ServerDrivenModel
import timber.log.Timber
import javax.inject.Inject

class MyApplicationRepositoryImpl @Inject constructor(
    private val myApplicationRemoteDataSource: MyApplicationRemoteDataSource
) : MyApplicationRepository {

    override suspend fun doFetch(): String =
        myApplicationRemoteDataSource.doFetch()
            .onSuccess {
                Timber.d("Database operation or something like that")
            }
            .getOrThrow()

    override suspend fun doServerDrivenFetch(): ServerDrivenModel =
        myApplicationRemoteDataSource.doServerDrivenFetch()
            .onSuccess {
                Timber.d("Database operation or something like that")
            }
            .getOrThrow()
}
