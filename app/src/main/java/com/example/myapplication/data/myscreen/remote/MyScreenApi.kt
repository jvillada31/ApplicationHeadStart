package com.example.myapplication.data.myscreen.remote

import com.example.myapplication.data.myscreen.remote.model.MyScreenResponse
import retrofit2.Response
import retrofit2.http.GET

interface MyScreenApi {

    @GET("https://run.mocky.io/v3/5bdced55-9eb9-4228-afa2-6f4fa21b3f1d")
    suspend fun getMyScreen(): Response<MyScreenResponse>
}
