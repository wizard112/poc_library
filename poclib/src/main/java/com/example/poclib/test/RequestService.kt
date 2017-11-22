package com.example.poclib.test

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by gael on 21.11.17.
 */
internal interface RequestService {
    @GET("product/737628064502.json")
    fun getProduct() : Observable<ResponseFood>
}