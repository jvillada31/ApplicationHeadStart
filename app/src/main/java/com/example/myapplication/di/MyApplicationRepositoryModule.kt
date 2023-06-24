package com.example.myapplication.di

import com.example.myapplication.data.myscreen.MyScreenRepositoryImpl
import com.example.myapplication.domain.myscreen.MyScreenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MyApplicationRepositoryModule {

    @Binds
    abstract fun bindMyApplicationRepository(
        myApplicationRepositoryImpl: MyScreenRepositoryImpl
    ): MyScreenRepository
}
