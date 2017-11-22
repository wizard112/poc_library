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
     * Generic method to check the permissions
     */
    fun checkPermissions(activity: AppCompatActivity,code : Int) {
        when(code) {
            PermissionConstants.ASK_PERMISSION_CAMERA -> { checkPermissionCamera(activity)}
            PermissionConstants.ASK_PERMISSION_WRITE_FILE -> {
                checkPermissionWriteFile(activity)}
        }
    }

    /**
     * Check camera permission
     *
     * @param activity
     */
    private fun checkPermissionCamera(activity: AppCompatActivity) {
        if(ActivityCompat.checkSelfPermission(activity,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.CAMERA),PermissionConstants.CODE_PERMISSION_CAMERA)
        }else{
            //OpenFeature.newIntentCamera(activity)
            OpenFeature.newIntentCameraWithFile(activity,activity)
        }
    }

    /**
     * Check write file permission
     *
     * @param activity
     */
    private fun checkPermissionWriteFile(activity: AppCompatActivity) {
        if(ActivityCompat.checkSelfPermission(activity,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),PermissionConstants.CODE_PERMISSION_WRITE_FILE)
        }else{

        }
    }
}