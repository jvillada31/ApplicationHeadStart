package com.example.myapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.myscreen.cache.MyScreenDao
import com.example.myapplication.data.myscreen.cache.MyScreenDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MyApplicationDatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): MyScreenDatabase {
        return Room.databaseBuilder(
            appContext,
            MyScreenDatabase::class.java,
            "Users"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideMyScreenDao(myScreenDatabase: MyScreenDatabase): MyScreenDao {
        return myScreenDatabase.myScreenDao()
    }
}
