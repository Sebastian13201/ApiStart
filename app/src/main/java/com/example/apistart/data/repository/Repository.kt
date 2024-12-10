package com.example.apistart.data.repository

import com.example.apistart.data.model.UserDetailModel

interface Repository {
    suspend fun getUser(): UserDetailModel
}