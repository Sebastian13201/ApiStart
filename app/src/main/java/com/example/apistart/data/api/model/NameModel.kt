package com.example.apistart.data.api.model


import com.google.gson.annotations.SerializedName

data class NameModel(
    @SerializedName("first")
    val first: String? = "",
    @SerializedName("last")
    val last: String? = "",
    @SerializedName("title")
    val title: String? = ""
)