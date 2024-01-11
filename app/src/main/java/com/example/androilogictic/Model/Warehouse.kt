package com.example.androilogictic.Model

import android.os.Parcel
import android.os.Parcelable

data class Warehouse(
    var id : String,
    var nameWarehouse: String,
    var areaWarehouse: String,
    var numberOrderWarehouse: Int

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(nameWarehouse)
        parcel.writeString(areaWarehouse)
        parcel.writeInt(numberOrderWarehouse)
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
