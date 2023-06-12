package com.example.myapplication.domain

interface MyApplicationRepository {

    suspend fun doFetch(): String
}
