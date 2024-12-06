package com.example.apistart.data.api.model


import com.google.gson.annotations.SerializedName

data class LocationModel(
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("coordinates")
    val coordinates: CoordinatesModel? = CoordinatesModel(),
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("postcode")
    val postcode: String? = "",
    @SerializedName("state")
    val state: String? = "",
    @SerializedName("street")
    val street: StreetModel? = StreetModel(),
    @SerializedName("timezone")
    val timezone: TimezoneModel? = TimezoneModel()
)