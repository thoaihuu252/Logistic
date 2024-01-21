package com.example.androilogictic.Model

import android.os.Parcel
import android.os.Parcelable
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
) : Parcelable {
    // Implement Parcelable cho Order
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        // Đọc productList từ Parcel
        mutableListOf<Product>().apply {
            parcel.readList(this, Product::class.java.classLoader)
        },
        // Đọc user từ Parcel
        parcel.readParcelable(User::class.java.classLoader)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(nameOrder)
        parcel.writeString(phoneOrder)
        parcel.writeInt(priceOrder)
        parcel.writeString(areaOrder)
        parcel.writeString(status)
        parcel.writeInt(ship)
        // Viết productList vào Parcel
        parcel.writeList(productList)
        // Viết user vào Parcel
        parcel.writeParcelable(user, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Order> {
        override fun createFromParcel(parcel: Parcel): Order {
            return Order(parcel)
        }

        override fun newArray(size: Int): Array<Order?> {
            return arrayOfNulls(size)
        }
    }
}