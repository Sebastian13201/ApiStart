package com.example.apistart.data.api.model


import com.google.gson.annotations.SerializedName

data class TimezoneModel(
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("offset")
    val offset: String? = ""
)