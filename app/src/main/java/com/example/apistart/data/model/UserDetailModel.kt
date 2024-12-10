package com.example.apistart.data.model


import com.google.gson.annotations.SerializedName

data class UserDetailModel(
    @SerializedName("drinks")
    val drinks: List<DrinkModel?>? = listOf()
)