package com.example.androilogictic.Model

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id")val id : String,
    @SerializedName("name")val name : String,
    @SerializedName("password") val password : String,
    @SerializedName("email")val email : String,
    @SerializedName("urlAvt") val urlAvt : String,
    @SerializedName("tottal") val total : Int
)