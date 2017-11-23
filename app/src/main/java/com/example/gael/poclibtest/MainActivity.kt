package com.example.gael.poclibtest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.poclib.test.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, ListeenrRequest{
    var manager : ManageResult? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = ManageResult(this,this)

        btn_camera_permission.setOnClickListener(this)
        btn_write_file_permission.setOnClickListener(this)
        btn_request_food.setOnClickListener(this)
        btn_check_gps.setOnClickListener(this)
        btn_check_network.setOnClickListener(this)

        MyUtils.getInstance(this)
    }

    override fun onClick(v: View?) {
       when(v!!.id) {
           R.id.btn_camera_permission -> {
               AskPermissions.checkPermissions(this,PermissionConstants.ASK_PERMISSION_CAMERA)
           }
           R.id.btn_write_file_permission -> {
               AskPermissions.checkPermissions(this,PermissionConstants.ASK_PERMISSION_WRITE_FILE)
           }
           R.id.btn_request_food -> {
               val r = MyUtils.getProducts(this)
               Log.i("Test",r.toString())
           }
           R.id.btn_check_gps -> { MyUtils.checkLocalisation(this)}
           R.id.btn_check_network -> { MyUtils.checkLocalisation(this,true)}
       }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        //AskPermissions.getInstance(this,this).onRequestPermissionsResult(requestCode, permissions, grantResults)
        manager!!.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //AskPermissions.getInstance(this,this).onActivityResult(requestCode, resultCode, data)
        manager!!.onActivityResult(requestCode, resultCode, data)
    }

    override fun getResponseFood(result: ResponseFood) {
        Log.i("Test",result.toString())
    }

    override fun getError(e: Throwable) {

    }

}
