package com.dicoding.catidentifierapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("cats")
    fun getCats(
    ): Call<List<ResponseItem>>
}