package com.amorjk1.languagetranslator

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_about_us.*

class AboutUsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        setSupportActionBar(toolbar)

    }

//    override fun onBackPressed() {
//        AlertDialog.Builder(this)
//            .setMessage("Are You Sure You want To exit")
//            .setCancelable(false)
//            .setPositiveButton("Yes", { dialog, id-> super@AboutUsActivity.onBackPressed() })
//            .setNegativeButton("No", null)
//            .show()
//    }

}
