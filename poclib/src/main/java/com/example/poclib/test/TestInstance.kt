package com.example.poclib.test

import android.content.Context

/**
 * Created by gael on 20.11.17.
 */
class TestInstance {

    companion object {

        private var myInstance : Int = 0

        /**
         * pattern @singleton, only instance
         */
        fun initialize(cxt : Context){
            if(myInstance == 0){
                myInstance = 1
                User("test",18)
            }
        }
    }
}