package com.example.poclib.test

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * This is class is a callback to handle result from permissions and implicit intent
 * Created by gael 21.11.17.
 */

class ManageResult(cxt : Context, ac : AppCompatActivity) : ListenerCommunication {

    private lateinit var context : Context
    private lateinit var activity : AppCompatActivity
    init {
        this.context = cxt
        this.activity = ac
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            PermissionConstants.CODE_PERMISSION_CAMERA -> {
                if(grantResults.size > 0 && grantResults.get(0) == PackageManager.PERMISSION_GRANTED) {
                    //OpenFeature.newIntentCamera(activity)
                    OpenFeature.newIntentCameraWithFile(context,activity)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    }
}