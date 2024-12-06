package com.example.apistart.data.api

import com.example.apistart.data.api.model.UserDetailModel
import retrofit2.http.GET

interface ApiClient {
    @GET(ApiDetails.ENDPOINT_USER)
    suspend fun getUser(): UserDetailModel
}