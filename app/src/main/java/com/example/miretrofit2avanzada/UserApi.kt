package com.example.miretrofit2avanzada

import retrofit2.Call
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    fun getAllUser(): Call<List<Users>>
}