package com.example.poclib.test

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by gael on 21.11.17.
 */
class LanguagesProduct {

    @Expose
    @SerializedName("en:english")
    var lngCountry : String? = null
        private set
}