package com.example.myapplication.domain

interface MyApplicationRepository {

    suspend fun doFetch(): String

    suspend fun doServerDrivenFetch(): ServerDrivenModel
}
