package com.amorjk1.languagetranslator

import Question
import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.MenuItem
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
import android.view.View as View1


class PlayScreenActivity : AppCompatActivity() {

//    private var txtScore: TextView? = null
//    private var txtQuestionCount: TextView? = null
//    private var txtCounter: TextView? = null
    private val questions = Question()
    //mQuestionView = findViewById(R.id.question) as TextView
    private lateinit var scoreView: TextView
    private lateinit var txtQuestion: TextView
    private lateinit var nButtonChoice1: Button
    private lateinit var nButtonChoice2: Button
    private lateinit var nButtonChoice3: Button
    private lateinit var nButtonChoice4: Button

    private var nAnswer:String? = ""
    private var nScore:Int = 0
    private var nQuestionNumber = 0

    lateinit var mTTs: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playscreen)

        setSupportActionBar(toolbar)

        scoreView = findViewById(R.id.txvScore)
        //nScore = findViewById(R.id.txvScore)
        txtQuestion = findViewById(R.id.txvQuestion)
       // txtQuestion = textView.findViewById(R.id.txvQuestion)
        nButtonChoice1 = findViewById(R.id.button1)
        nButtonChoice2 = findViewById(R.id.button2)
        nButtonChoice3 = findViewById(R.id.button3)
        nButtonChoice4 = findViewById(R.id.button4)

        updateQuestion()

        nButtonChoice1.setOnClickListener(View1.OnClickListener {

            if (nButtonChoice1.getText() == nAnswer)
            {
                //correct answer
                nScore += 1;
                updateScore(nScore);
                Toast.makeText(this@PlayScreenActivity, "correct", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
            else
            {
                //incorrect
                Toast.makeText(this@PlayScreenActivity, "wrong", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
        })

        nButtonChoice2.setOnClickListener(View1.OnClickListener {

            if (nButtonChoice2.getText() == nAnswer)
            {
                //correct answer
                nScore += 1;
                updateScore(nScore);
                Toast.makeText(this@PlayScreenActivity, "correct", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
            else
            {
                //incorrect
                Toast.makeText(this@PlayScreenActivity, "wrong", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
        })

        nButtonChoice3.setOnClickListener(View1.OnClickListener {

            if (nButtonChoice3.getText() == nAnswer)
            {
                //correct answer
                nScore += 1;
                updateScore(nScore);
                Toast.makeText(this@PlayScreenActivity, "correct", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
            else
            {
                //incorrect
                Toast.makeText(this@PlayScreenActivity, "wrong", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
        })

        nButtonChoice4.setOnClickListener(View1.OnClickListener {

            if (nButtonChoice4.getText() == nAnswer)
            {
                //correct answer
                nScore += 1;
                updateScore(nScore);
                Toast.makeText(this@PlayScreenActivity, "correct", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
            else
            {
                //incorrect
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

        val speakBtn = findViewById<View1>(R.id.buttonSpeak)
        speakBtn.setOnClickListener{
            //val toSpeak2 = textView.text.toString()
            //val toSpeak = editText.text.toString()
            val toSpeak2 = txtQuestion.text.toString()
            if (toSpeak2 == ""){
                Toast.makeText(this,"Enter Text",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,toSpeak2,Toast.LENGTH_LONG).show()
                mTTs.speak(toSpeak2, TextToSpeech.QUEUE_FLUSH,null)
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
        txtQuestion.setText(questions.getQuestion(nQuestionNumber))
        nButtonChoice1.setText(questions.getChoice1(nQuestionNumber))
        nButtonChoice2.setText(questions.getChoice2(nQuestionNumber))
        nButtonChoice3.setText(questions.getChoice3(nQuestionNumber))
        nButtonChoice4.setText(questions.getChoice4(nQuestionNumber))

        nAnswer = questions.getCorrectAnswer(nQuestionNumber)
        nQuestionNumber++

    }

    private fun updateScore(point:Int) {
        scoreView.setText("Score:" + nScore)
    }

}
