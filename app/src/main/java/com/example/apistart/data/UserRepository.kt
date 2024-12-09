package com.example.apistart.data

import com.example.apistart.data.api.ApiClient
import com.example.apistart.data.api.model.UserDetailModel
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiClient: ApiClient){
    suspend fun fetchUsers(): UserDetailModel? {
        return apiClient.getUser()
    }
}