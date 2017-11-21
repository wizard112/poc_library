package com.example.gael.poclibtest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.poclib.test.AskPermissions
import com.example.poclib.test.ManageResult
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{

    var manager : ManageResult? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = ManageResult(this,this)

        btn_camera_permission.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when(v!!.id) {
           R.id.btn_camera_permission -> {
               AskPermissions.checkPermissionCamera(this)
           }
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

}
