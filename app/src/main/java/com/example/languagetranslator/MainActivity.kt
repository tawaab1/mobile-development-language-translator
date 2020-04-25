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
import android.speech.tts.TextToSpeech
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_playscreen.*
import java.util.*


class MainActivity : AppCompatActivity() {

    //lateinit var mTTs:TextToSpeech
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        
        //speak button

        
        //val speakBtn = findViewById<View>(R.id.buttonSpeak)
        //speakBtn.setOnClickListener(YoutubeButtonOnClickListener())

        //val editText = findViewById<View>(R.id.editText)
        
        
        
        
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
                startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    
}
