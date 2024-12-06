package com.example.apistart.data.api.model


import com.google.gson.annotations.SerializedName

data class UserDetailModel(
    @SerializedName("info")
    val info: InfoModel? = InfoModel(),
    @SerializedName("results")
    val results: List<ResultModel?>? = listOf()
)