package com.example.apistart.util

import com.example.apistart.data.model.UserDetailModel

sealed class ResponseState {
    //loading
    object Loading : ResponseState()

    //success
    data class Success(val result: UserDetailModel) :
        ResponseState() //ideally we should make it generic

    //failure
    data class Fail(val error: String) : ResponseState()
}