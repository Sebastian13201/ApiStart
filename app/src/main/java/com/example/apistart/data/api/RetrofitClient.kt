package com.example.apistart.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofitInstance = Retrofit.Builder()
        .baseUrl(ApiDetails.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiInstance = retrofitInstance.create(ApiClient::class.java)
}