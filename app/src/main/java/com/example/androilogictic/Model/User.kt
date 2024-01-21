package com.example.androilogictic.Model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("password") val password: String,
    @SerializedName("email") val email: String,
    @SerializedName("urlAvt") val urlAvt: String,
    @SerializedName("total") val total: Int
) : Parcelable {
    // Implement Parcelable cho User
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(password)
        parcel.writeString(email)
        parcel.writeString(urlAvt)
        parcel.writeInt(total)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}
