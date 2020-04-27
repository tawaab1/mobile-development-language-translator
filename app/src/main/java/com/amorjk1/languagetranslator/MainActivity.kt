package com.amorjk1.languagetranslator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    //lateinit var mTTs:TextToSpeech
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar1)

        
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

    /**
     * onOptionsItemSelected() is used to navigate to different screens using the drawable items
     * action_search and action_setting
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            /**
             * navigates to the BottomNavigationActivity
             */
            R.id.action_search -> {
                startActivity(Intent(this@MainActivity, BottomNavigationActivity::class.java))
                true
            }
            /**
             * navigates to the SettingsActivity
             */
            R.id.action_settings -> {
                startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    
}
