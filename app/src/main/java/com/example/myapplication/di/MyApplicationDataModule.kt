package com.example.myapplication.di

import com.example.myapplication.data.MyApplicationRepositoryImpl
import com.example.myapplication.domain.MyApplicationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MyApplicationDataModule {

    @Binds
    abstract fun bindMyApplicationRepository(
        myApplicationRepositoryImpl: MyApplicationRepositoryImpl
    ): MyApplicationRepository
}
