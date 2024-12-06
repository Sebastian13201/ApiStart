package com.example.apistart.data.api.model


import com.google.gson.annotations.SerializedName

data class IdModel(
    @SerializedName("name")
    val name: String? = "",
//    @SerializedName("value")
//    val value: AnyModel? = AnyModel()
)