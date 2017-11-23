package com.example.poclib.test

import android.content.Context
import android.content.Intent
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.util.Log
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * This class allows to manage the date, gives a string for a specific date
 * Created on 21.11.17.
 */

object OpenFeature {

    /**
     * start the implicit intent to take photo
     */
    fun newIntentCamera(activity: AppCompatActivity){
        activity.startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE),PermissionConstants.CODE_PERMISSION_CAMERA)
    }

    /**
     * start the implicit intent to take photo and create the file to save image
     *
     * @exception occurs when we try to create the file
     */
    fun newIntentCameraWithFile(context: Context,activity: AppCompatActivity){
        var takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        var photoFile : File? = null
        try {
            photoFile = ManagerFile.createFileForImage(context,activity)
            Log.i("Test","create the file ")
        }catch (e : Exception) {
            e.printStackTrace()
        }

        if(photoFile != null) {
            val photoUri = FileProvider.getUriForFile(context,context.packageName,photoFile)
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri)
            Log.i("Test","get uri file and add like an extr into intent ")
        }
        activity.startActivityForResult(takePictureIntent,PermissionConstants.CODE_PERMISSION_CAMERA)
    }

    /**
     * Launch an implicit intent to open settings' gps
     *
     * @param context
     */
    fun newIntentEnabledGPS(context: Context){
        context.startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
    }

    /**
     * Launch an implicit intent to open settings' network
     *
     * @param context
     */
    fun newIntentEnabledNetwork(context: Context){
        //context.startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
        context.startActivity(Intent((android.provider.Settings.ACTION_WIRELESS_SETTINGS)))
    }

}