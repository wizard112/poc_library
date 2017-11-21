package com.example.poclib.test

import java.text.SimpleDateFormat
import java.util.*

/**
 * This class allows to manage the time
 * Created on 21.11.17.
 */

object ManagerTime {

    /**
     * get the current date in String
     *
     * @return String
     */
    fun getDateString() : String {
        val dateFormat = SimpleDateFormat("dd_MM_yyyy")
        val date = Date()
        return dateFormat.format(date)
    }
}