package com.amorjk1.languagetranslator

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.activity_playscreen.*
import java.util.*
import kotlinx.android.synthetic.main.activity_bottom_navigation.toolbar as toolbar1

class PlayScreenActivity : AppCompatActivity() {

    lateinit var mTTs: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playscreen)
        setSupportActionBar(toolbar1)
        /**
         * calling the class OnNavigationItemSelectedListener() to the onCreate() method
         */
        bnv.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener())
        bnv.menu.getItem(1).isChecked = true

        mTTs = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR){
                //check for no errors
                mTTs.language = Locale.UK
            }
        })

        val speakBtn = findViewById<View>(R.id.buttonSpeak)
        speakBtn.setOnClickListener{
            val toSpeak = editText.text.toString()
            if (toSpeak == ""){
                Toast.makeText(this,"Enter Text",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,toSpeak,Toast.LENGTH_LONG).show()
                mTTs.speak(toSpeak, TextToSpeech.QUEUE_FLUSH,null)
            }

        }

    }
    inner class OnNavigationItemSelectedListener : BottomNavigationView.OnNavigationItemSelectedListener{
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            return when (item.itemId){
                /**
                 * navigates to the MainActivity
                 */
                R.id.navigation_home -> {
                    startActivity(Intent(this@PlayScreenActivity, MainActivity::class.java))
                    finish()
                    true
                }
                /**
                 * navigates to the About Us activity
                 */
                R.id.navigation_aboutus ->{
                    startActivity(Intent(this@PlayScreenActivity, AboutUsActivity::class.java))
                    finish()
                    true
                }
                /**
                 * navigates to the About Us activity
                 */
                R.id.navigation_playquiz->{
                    startActivity(Intent(this@PlayScreenActivity, PlayScreenActivity::class.java))
                    finish()
                    true
                }
                else -> onNavigationItemSelected(item)
            }

        }

    }

}
