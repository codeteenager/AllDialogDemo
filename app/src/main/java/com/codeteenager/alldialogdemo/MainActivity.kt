package com.codeteenager.alldialogdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.codeteenager.alldialoglib.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btn_open)
        btn.setOnClickListener(View.OnClickListener {
            val dialog = AlertDialog.Builder(this)
                    .setContentView(R.layout.dialog)
                    .setText(R.id.tv_title, "哈哈")
                    .setOnClickListener(R.id.btn_start, View.OnClickListener {
                        Toast.makeText(this, "点击", Toast.LENGTH_LONG).show()
                    })
                    .fromTop(true)
                    .fullWidth()
                    .show()

        })

    }
}
