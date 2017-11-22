package com.example.poclib.test

/**
 * Created on 21.11.17.
 */

interface ListeenrRequest {
    fun getResponseFood(result : ResponseFood)
    fun getError(e: Throwable)
}