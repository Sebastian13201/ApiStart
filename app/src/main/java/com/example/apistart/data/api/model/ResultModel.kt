package com.example.apistart.data.api.model


import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("cell")
    val cell: String? = "",
    @SerializedName("dob")
    val dob: DobModel? = DobModel(),
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("gender")
    val gender: String? = "",
    @SerializedName("id")
    val id: IdModel? = IdModel(),
    @SerializedName("location")
    val location: LocationModel? = LocationModel(),
    @SerializedName("login")
    val login: LoginModel? = LoginModel(),
    @SerializedName("name")
    val name: NameModel? = NameModel(),
    @SerializedName("nat")
    val nat: String? = "",
    @SerializedName("phone")
    val phone: String? = "",
    @SerializedName("picture")
    val picture: PictureModel? = PictureModel(),
    @SerializedName("registered")
    val registered: RegisteredModel? = RegisteredModel()
)