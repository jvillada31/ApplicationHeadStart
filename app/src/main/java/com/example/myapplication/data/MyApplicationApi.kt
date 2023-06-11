package com.example.myapplication.data

import retrofit2.Response
import retrofit2.http.GET

interface MyApplicationApi {

    @GET("https://run.mocky.io/v3/fb853cab-3570-461f-b6fc-0a1c389d8af5")
    suspend fun doSomething(): Response<String>
}
