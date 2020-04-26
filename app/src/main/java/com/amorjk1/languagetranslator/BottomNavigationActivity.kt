package com.amorjk1.languagetranslator

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        /**
         * enables toolbar capabilities
         */
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        /**
         * calling the class OnNavigationItemSelectedListener() to the onCreate() method
         */
        bnv.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener())
        bnv.menu.getItem(1).isChecked = true
    }
    /**
     * OnNavigationItemSelectedListener() used to switch between the activities
     */
    inner class OnNavigationItemSelectedListener : BottomNavigationView.OnNavigationItemSelectedListener{
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            return when (item.itemId){
                /**
                 * navigates to the MainActivity
                 */
                R.id.navigation_home -> {
                    startActivity(Intent(this@BottomNavigationActivity, MainActivity::class.java))
                    finish()
                    true
                }
                /**
                 * navigates to a different activity
                 */
                R.id.navigation_aboutus -> true
                else -> onNavigationItemSelected(item)
            }

        }

    }



}
