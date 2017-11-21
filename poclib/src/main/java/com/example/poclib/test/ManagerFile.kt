package com.example.poclib.test

import android.content.Context
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import java.io.File

/**
 * THis class allows to manage a file, to create it
 *
 * Created on 21.11.17.
 */
object ManagerFile {

    /**
     * @property
     */
    var mPathImageFile : String = ""
        private set

    /**
     * Create a temporary file, in external storage area of application, to save the captured image
     * save the path in @mPathImageFile
     *
     * @param context
     * @param activity
     * @return the created file
     */
    fun createFileForImage(context: Context, activity: AppCompatActivity) : File{
        val timestamp = ManagerTime.getDateString()
        val name = "JPEG_".plus(timestamp).plus("_")
        var storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        var image = File.createTempFile(name,
                ".jpg",
                storageDir)
        mPathImageFile = image.absolutePath
        return image
    }
}