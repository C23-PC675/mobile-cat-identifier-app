package com.dicoding.catidentifierapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object {
        fun getApiService(): ApiService {
            val url = "https://catidentifier-api-dkxmr2pyqa-et.a.run.app/"
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}