package com.codeteenager.alldialogdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.codeteenager.alldialoglib.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dialog= AlertDialog.Builder(this)
                .setContentView(R.layout.activity_main)
                .setText()
                .setOnClickListener()
                .show();
    }
}
