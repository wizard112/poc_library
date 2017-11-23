package com.example.poclib.test

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * Created on 22.11.17.
 */

class NotificationTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("Test","in on create")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Test","in on resume")
    }

    /*
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.i("Test","in on new intent")
    }
    */
}