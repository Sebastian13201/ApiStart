package com.example.apistart.data.api.model


import com.google.gson.annotations.SerializedName

data class CoordinatesModel(
    @SerializedName("latitude")
    val latitude: String? = "",
    @SerializedName("longitude")
    val longitude: String? = ""
)