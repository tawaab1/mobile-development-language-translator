package com.amorjk1.languagetranslator

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_playscreen.*
import java.util.*
import kotlin.collections.ArrayList


class PlayScreenActivity : AppCompatActivity() {

    lateinit var mTTs: TextToSpeech
    lateinit var currentQuestion: Question
    var questionNumber = 0
    val maxNumQuestions = 5
    lateinit var qAnswers:ArrayList<String>
    lateinit var selectedQuestion:String

    var questionsArray = arrayListOf<Question>(
        Question(theQuestion = "How many Islands in New Zealand", theAnswer = arrayListOf("1","2","3","4")),
        Question(theQuestion = "Who is the prime minister of nz", theAnswer = arrayListOf("brown","yellow","black","green")),
        Question(theQuestion = "Who am i", theAnswer = arrayListOf("John","Sam","Roy","Chris")),
        Question(theQuestion = "Jesus is?", theAnswer = arrayListOf("King","King2","King3","King6")),
        Question(theQuestion = "How tall am i?", theAnswer = arrayListOf("tall","taller","tall-ish","tallest"))

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playscreen)



        setSupportActionBar(toolbar)
        /**
         * calling the class OnNavigationItemSelectedListener() to the onCreate() method
         */
        bnv2.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener())
        bnv2.menu.getItem(1).isChecked = true

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
                /**
                 * navigates to the Contact Us activity
                 */
                R.id.navigation_contactus->{
                    startActivity(Intent(this@PlayScreenActivity, ContactUsActivity::class.java))
                    finish()
                    true
                }
                else -> onNavigationItemSelected(item)
            }
        }
    }

    fun setQuestion(){
        currentQuestion = questionsArray[questionNumber]
        qAnswers = ArrayList(currentQuestion.theAnswer)
        qAnswers.shuffle()
    }

    fun randomQuestion(){
        questionsArray.shuffle()
        setQuestion()
        //Log.d("ANSWER",qAnswers[0],qAnswers[1],qAnswers[2],qAnswers[3])
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
