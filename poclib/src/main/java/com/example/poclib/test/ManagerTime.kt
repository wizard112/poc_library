package com.example.poclib.test

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created on 21.11.17.
 */

object ManagerTime {

    fun getDateString() : String {
        val dateFormat = SimpleDateFormat("dd_MM_yyyy")
        val date = Date()
        return dateFormat.format(date)
    }
}