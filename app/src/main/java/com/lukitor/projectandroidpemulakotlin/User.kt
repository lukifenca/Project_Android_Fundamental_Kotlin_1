package com.lukitor.projectandroidpemulakotlin

import android.os.Parcel
import android.os.Parcelable

data class User(
    var username: String? = "", var nama: String? = "", var love: String? = "",
    var follower: String? = "", var following: String? = "", var repository: String? = "",
    var location: String? = "", var link: String? = "", var company: String? = "",
    var foto: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(username)
        parcel.writeString(nama)
        parcel.writeString(love)
        parcel.writeString(follower)
        parcel.writeString(following)
        parcel.writeString(repository)
        parcel.writeString(location)
        parcel.writeString(link)
        parcel.writeString(company)
        parcel.writeInt(foto)
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