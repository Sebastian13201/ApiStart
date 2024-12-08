package com.example.apistart.data

import com.example.apistart.data.api.model.UserDetailModel
import retrofit2.Response

sealed class ResponseState {
    //loading
    object Loading : ResponseState()

    //success
    data class Success(val result: UserDetailModel) :
        ResponseState() //ideally we should make it generic

    //failure
    data class Fail(val error: String) : ResponseState()
}