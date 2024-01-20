package com.example.androilogictic.Model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: Int,
    @SerializedName("shop") val shop: String,
    @SerializedName("imageUrl") val imageUrl: String
)
