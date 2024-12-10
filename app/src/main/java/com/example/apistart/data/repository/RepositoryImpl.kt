package com.example.apistart.data.repository

import com.example.apistart.data.api.ApiClient
import com.example.apistart.data.model.UserDetailModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val apiClient: ApiClient): Repository {
    override suspend fun getUser(): UserDetailModel {
        return apiClient.getUser()
    }

}