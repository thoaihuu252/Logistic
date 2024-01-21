package com.example.androilogictic.Model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Warehouse(
    @SerializedName("id") val  id  :String,
    @SerializedName("nameWh") val  nameWh : String, //Warehouse - wh
    @SerializedName("areaWh") val  areaWh:String,
    @SerializedName("numberOrderWh") val numberOrderWh: Int,
    @SerializedName("productList") val productList : ArrayList<Order>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        ArrayList<Order>().apply {
            parcel.readArrayList( Order::class.java.classLoader) as ArrayList<Order>
        }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(nameWh)
        parcel.writeString(areaWh)
        parcel.writeInt(numberOrderWh)
        parcel.writeList(productList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Warehouse> {
        override fun createFromParcel(parcel: Parcel): Warehouse {
            return Warehouse(parcel)
        }

        override fun newArray(size: Int): Array<Warehouse?> {
            return arrayOfNulls(size)
        }
    }
}

