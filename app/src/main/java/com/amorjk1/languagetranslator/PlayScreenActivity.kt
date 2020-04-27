package com.amorjk1.languagetranslator

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_playscreen.*
import java.util.*
import kotlinx.android.synthetic.main.activity_bottom_navigation.toolbar as toolbar1

class PlayScreenActivity : AppCompatActivity() {

    lateinit var mTTs: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playscreen)
        setSupportActionBar(toolbar)

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

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Are You Sure You want To Go Back")
            .setCancelable(false)
            .setPositiveButton("Yes", { dialog, id-> super@PlayScreenActivity.onBackPressed() })
            .setNegativeButton("No", null)
            .show()
    }

}
