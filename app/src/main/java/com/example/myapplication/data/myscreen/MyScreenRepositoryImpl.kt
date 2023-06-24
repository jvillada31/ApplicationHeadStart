package com.example.myapplication.data.myscreen

import com.example.myapplication.data.myscreen.remote.MyScreenRemoteDataSource
import com.example.myapplication.domain.myscreen.model.MyScreenModel
import com.example.myapplication.domain.myscreen.repository.MyScreenRepository
import timber.log.Timber
import javax.inject.Inject

class MyScreenRepositoryImpl @Inject constructor(
    private val myScreenRemoteDataSource: MyScreenRemoteDataSource
) : MyScreenRepository {

    override suspend fun getMyScreen(): MyScreenModel =
        myScreenRemoteDataSource.getMyScreen()
            .onSuccess {
                Timber.d("Database operation or something like that")
            }
            .getOrThrow()
}
