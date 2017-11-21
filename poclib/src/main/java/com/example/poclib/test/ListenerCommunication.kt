package com.example.poclib.test

import android.content.Intent

/**
 * Created by gael on 21.11.17.
 */

interface ListenerCommunication {

    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
}