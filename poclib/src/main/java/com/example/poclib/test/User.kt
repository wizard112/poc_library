package com.example.poclib.test

/**
 * Created by gael on 21.11.17.
 */
internal class User (name : String, number : Int){
    private lateinit var name : String
    private var number : Int? = null
    init {
        this.name = name
        this.number = number
    }

}