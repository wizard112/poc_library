package com.example.poclib.test

import android.content.Context
import android.content.Intent
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity

/**
 * Created by gael on 21.11.17.
 */

object OpenFeature {

    fun newIntentCamera(activity: AppCompatActivity){
        activity.startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE),PermissionConstants.CODE_PERMISSION_CAMERA)
    }
}