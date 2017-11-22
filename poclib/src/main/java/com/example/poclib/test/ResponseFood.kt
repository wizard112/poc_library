package com.example.poclib.test

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by gael on 21.11.17.
 */

class ResponseFood () : Parcelable{

    @Expose
    var code : String? = null
        private set
    @Expose
    var status : Int? = null
        private set
    @Expose
    var status_verbose : String? = null
        private set

    @Expose
    var product : ProductResponseFood? = null
        private set

    constructor(parcel: Parcel) : this() {
        code = parcel.readString()
        status = parcel.readInt()
        status_verbose = parcel.readString()
    }

    constructor(code : String, status : Int, status_verbose : String) : this(){
        this.code = code
        this.status_verbose = status_verbose
        this.status = status
    }

    override fun toString() : String {
        return code.plus(" - ").plus(status).plus(" - ").plus(status_verbose).plus(" - ").plus(product!!.toString())
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(code)
        parcel.writeInt(status!!)
        parcel.writeString(status_verbose)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResponseFood> {
        override fun createFromParcel(parcel: Parcel): ResponseFood {
            return ResponseFood(parcel)
        }

        override fun newArray(size: Int): Array<ResponseFood?> {
            return arrayOfNulls(size)
        }
    }
}