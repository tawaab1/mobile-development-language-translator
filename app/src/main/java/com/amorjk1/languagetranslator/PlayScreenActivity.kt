package com.amorjk1.languagetranslator

import Question
import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.amorjk1.languagetranslator.R.id.txvQuestion
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_playscreen.*
import kotlinx.android.synthetic.main.content_about_us.*
import java.lang.reflect.Array.get
import java.util.*
import kotlin.collections.ArrayList


class PlayScreenActivity : AppCompatActivity() {

//    private var txtScore: TextView? = null
//    private var txtQuestionCount: TextView? = null
//    private var txtCounter: TextView? = null
    private val questions = Question()
    //private lateinit var txtQuestion: TextView
    private lateinit var nButtonChoice1: Button
    private lateinit var nButtonChoice2: Button
    private lateinit var nButtonChoice3: Button
    private lateinit var nButtonChoice4: Button

    private var nAnswer:String? = ""
    //private val nScore:Int = 0
    private var nQuestionNumber = 0

    lateinit var mTTs: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playscreen)

        setSupportActionBar(toolbar)

        //txtQuestion = textView.findViewById(R.id.txvQuestion)
        nButtonChoice1 = findViewById(R.id.button1)
        nButtonChoice2 = findViewById(R.id.button2)
        nButtonChoice3 = findViewById(R.id.button3)
        nButtonChoice4 = findViewById(R.id.button4)

        updateQuestion()

        nButtonChoice1.setOnClickListener(View.OnClickListener {

            if (nButtonChoice1.getText() == nAnswer)
            {
                Toast.makeText(this@PlayScreenActivity, "correct", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
            else
            {
                Toast.makeText(this@PlayScreenActivity, "wrong", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
        })

        nButtonChoice2.setOnClickListener(View.OnClickListener {

            if (nButtonChoice2.getText() == nAnswer)
            {
                Toast.makeText(this@PlayScreenActivity, "correct", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
            else
            {
                Toast.makeText(this@PlayScreenActivity, "wrong", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
        })

        nButtonChoice3.setOnClickListener(View.OnClickListener {

            if (nButtonChoice3.getText() == nAnswer)
            {
                Toast.makeText(this@PlayScreenActivity, "correct", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
            else
            {
                Toast.makeText(this@PlayScreenActivity, "wrong", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
        })

        nButtonChoice4.setOnClickListener(View.OnClickListener {

            if (nButtonChoice4.getText() == nAnswer)
            {
                Toast.makeText(this@PlayScreenActivity, "correct", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
            else
            {
                Toast.makeText(this@PlayScreenActivity, "wrong", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
        })
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

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Are You Sure You want To Go Back")
            .setCancelable(false)
            .setPositiveButton("Yes", { dialog, id-> super@PlayScreenActivity.onBackPressed() })
            .setNegativeButton("No", null)
            .show()
    }

    private fun updateQuestion() {
        //txtQuestion.setText(questions.getQuestion(nQuestionNumber))
        nButtonChoice1.setText(questions.getChoice1(nQuestionNumber))
        nButtonChoice2.setText(questions.getChoice2(nQuestionNumber))
        nButtonChoice3.setText(questions.getChoice3(nQuestionNumber))
        nButtonChoice4.setText(questions.getChoice4(nQuestionNumber))

        nAnswer = questions.getCorrectAnswer(nQuestionNumber)
        nQuestionNumber++

    }

}
