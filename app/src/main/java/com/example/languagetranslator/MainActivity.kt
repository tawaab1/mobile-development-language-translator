package com.example.languagetranslator

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        
        startButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, PlayScreenActivity::class.java)
            startActivity(intent) })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                startActivity(Intent(this@MainActivity, BottomNavigationActivity::class.java))
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this@MainActivity, "Settings", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    
}
