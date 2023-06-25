package com.example.myapplication.data.myscreen

import com.example.myapplication.data.myscreen.cache.MyScreenCacheDataSource
import com.example.myapplication.data.myscreen.remote.MyScreenRemoteDataSource
import com.example.myapplication.domain.myscreen.MyScreenRepository
import com.example.myapplication.domain.myscreen.model.MyScreenModel
import timber.log.Timber
import javax.inject.Inject

class MyScreenRepositoryImpl @Inject constructor(
    private val myScreenCacheDataSource: MyScreenCacheDataSource,
    private val myScreenRemoteDataSource: MyScreenRemoteDataSource
) : MyScreenRepository {

    override suspend fun getMyScreen(): MyScreenModel =
        myScreenRemoteDataSource.getMyScreen()
            .onSuccess { myScreenModel ->
                Timber.d("Persist the result from remote in cache")
                myScreenCacheDataSource.storeMyScreen(myScreenModel)
            }
            .getOrThrow()
}
