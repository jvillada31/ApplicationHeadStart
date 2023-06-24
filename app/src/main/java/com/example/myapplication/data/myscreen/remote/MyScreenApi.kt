package com.example.myapplication.data.myscreen.remote

import com.example.myapplication.data.ServerDrivenResponse
import retrofit2.Response
import retrofit2.http.GET

interface MyScreenApi {

    @GET("https://run.mocky.io/v3/7ffba17d-1870-45cd-ab31-f0606f47dc09")
    suspend fun doServerDrivenFetch(): Response<ServerDrivenResponse>

    @GET("https://run.mocky.io/v3/8f7883cd-ffe6-46ec-9e21-9b183e3aa1ce")
    suspend fun getMyScreen(): Response<MyScreenResponse>
}
