package com.example.languagetranslator

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.whenCreated
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        bnv.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener())
        bnv.menu.getItem(1).isChecked = true
    }
    inner class OnNavigationItemSelectedListener : BottomNavigationView.OnNavigationItemSelectedListener{
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            return when (item.itemId){
                R.id.navigation_home -> {
                    startActivity(Intent(this@BottomNavigationActivity, MainActivity::class.java))
                    finish()
                    true
                }
                R.id.navigation_aboutus -> true
                else -> onNavigationItemSelected(item)
            }

        }

    }



}
