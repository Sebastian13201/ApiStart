package com.example.apistart.data.api.model


import com.google.gson.annotations.SerializedName

data class InfoModel(
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("results")
    val results: Int? = 0,
    @SerializedName("seed")
    val seed: String? = "",
    @SerializedName("version")
    val version: String? = ""
)