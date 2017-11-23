package com.example.poclib.test

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ResolveInfo
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

    /**
     * Launch intent to share my content
     *
     * @param context
     * @param msg the message to share
     * info : https://stackoverflow.com/questions/34618514/share-text-via-intent-on-facebook-without-using-facebook-sdk
     */
    fun newIntentShareContent(context: Context, msg : String = "http://www.google.com") {
        var intentShare : Intent = Intent(Intent.ACTION_SEND)
        intentShare.setType("text/plain")
        intentShare.putExtra(android.content.Intent.EXTRA_TEXT,msg)
        /*var pm  = context.packageManager

        pm.queryIntentActivities(intentShare,0).forEach { t: ResolveInfo? ->
            if((t!!.activityInfo.name.contains("facebook"))) {
                var ac = t.activityInfo
                var name = ComponentName(ac.applicationInfo.packageName,ac.name)

            }
        }*/

        context.startActivity(Intent.createChooser(intentShare,"My share"))
    }

}