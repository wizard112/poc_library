package com.example.poclib.test

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity

/**
 * This class allows to manage the permissions
 * Created on 21.11.17.
 */

object AskPermissions {

    private var manager : ManageResult? = null

    fun getInstance(context: Context, activity: AppCompatActivity) : ManageResult{
        if(manager == null) {
            manager = ManageResult(context,activity)
        }
        return manager!!
    }

    /**
     * Check camera permission
     *
     * @param activity
     */
    fun checkPermissionCamera(activity: AppCompatActivity) {
        if(ActivityCompat.checkSelfPermission(activity,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.CAMERA),PermissionConstants.CODE_PERMISSION_CAMERA)
        }else{
            //OpenFeature.newIntentCamera(activity)
            OpenFeature.newIntentCameraWithFile(activity,activity)
        }
    }
}