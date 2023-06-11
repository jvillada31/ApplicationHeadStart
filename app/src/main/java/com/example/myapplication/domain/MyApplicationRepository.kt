package com.example.myapplication.domain

interface MyApplicationRepository {

    suspend fun doSomething(): String
}
