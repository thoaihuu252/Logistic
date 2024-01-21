package com.example.androilogictic.Model

import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("id") val id: String,
    @SerializedName("nameOrder") val nameOrder: String,
    @SerializedName("phoneOrder") val phoneOrder: String,
    @SerializedName("priceOrder") val priceOrder: Int,
    @SerializedName("areaOrder") val areaOrder: String,
    @SerializedName("status") val status: String,
    @SerializedName("ship") val ship: Int,
    @SerializedName("products") val productList: List<Product>,
    @SerializedName("user") val user: User
)
