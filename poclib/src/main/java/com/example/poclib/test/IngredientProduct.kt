package com.example.poclib.test

import com.google.gson.annotations.Expose

/**
 * Created on 21.11.17.
 */
class IngredientProduct {
    @Expose
    var text : String? = null

    @Expose
    var rank : Int? = null

    @Expose
    var id : String? = null

    override fun toString(): String {
        return text.plus(" ").plus(rank).plus(" ").plus(id)
    }
}