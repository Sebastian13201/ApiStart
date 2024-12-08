package com.example.apistart.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

//    private val okhttpClient: OkHttpClient = OkHttpClient.Builder()
//        .addInterceptor(HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        })
//        .build()
//
//    private val retrofitInstance = Retrofit.Builder()
//        .baseUrl(ApiDetails.BASE_URL)
//        .client(okhttpClient)  // -> customisation and addition of properties
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val apiInstance = retrofitInstance.create(ApiClient::class.java)

}