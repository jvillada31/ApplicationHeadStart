package com.example.myapplication.domain.myscreen.repository

import com.example.myapplication.domain.myscreen.model.MyScreenModel

interface MyScreenRepository {

    suspend fun getMyScreen(): MyScreenModel
}
