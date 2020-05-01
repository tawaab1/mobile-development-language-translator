/*
translation activity
translates text input to different languages
text to speeech feature as well
option to select different language to translate and speak
 */
package com.amorjk1.languagetranslator

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_translation.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.*


class TranslationActivity : AppCompatActivity() {

    lateinit var tts: TextToSpeech
    lateinit var translatedSpinner: Spinner
    lateinit var originalText: EditText
    lateinit var translatedText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translation)
        setSupportActionBar(toolbar)
        /**
         * run the setupSpinner
         */
        setupSpinner()

        bnv5.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener())
        bnv5.menu.getItem(1).isChecked = true
        /**
         * TTS code
         */
        tts = TextToSpeech(this, TextToSpeechInit())
        translatedSpinner = findViewById(R.id.transSpinner)
        originalText = findViewById(R.id.word2Trans)
        translatedText = findViewById(R.id.transText)

        /**
         * Pressing the TTS button
         */
        val speakButton = findViewById<ImageButton>(R.id.transSpeak)
        speakButton.setOnClickListener(SpeakButtonClickHandler())

        /**
         * Pressing the translate buttons
         */
        val translateButton = findViewById<Button>(R.id.transButton)
        translateButton.setOnClickListener(TranslateButtonClickHandler())
    }

    private fun setupSpinner() {
        val translatedLanguage = arrayOf<String?>(
            "Select Language:",
            "English",
            "French",
            "German",
            "Italian",
            "Spanish"
        )

        translatedSpinner = findViewById(R.id.transSpinner)
        translatedSpinner.adapter = ArrayAdapter<Any?>(
            this@TranslationActivity,
            R.layout.support_simple_spinner_dropdown_item,
            translatedLanguage
        )
    }
    inner class TextToSpeechInit : OnInitListener {
        override fun onInit(status: Int) {
            if (status == TextToSpeech.SUCCESS) {
                val result = tts.setLanguage(Locale.US)
                tts.setSpeechRate(0.8.toFloat())
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.i("Error", "Language not supported or missing data")
                }
            }
        }
    }


    inner class TranslateButtonClickHandler : View.OnClickListener {
        override fun onClick(v: View) {

            var languageCode: String? = null
            val translatedLanguageSelected =
                this@TranslationActivity.translatedSpinner.selectedItem.toString()
            if (translatedLanguageSelected == "Select Language:") {
                Toast.makeText(
                    this@TranslationActivity,
                    "Please select a language preference",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                when (translatedLanguageSelected) {
                    "English" -> languageCode = "en"
                    "French" -> languageCode = "fr"
                    "Spanish" -> languageCode = "es"
                    "German" -> languageCode = "de"
                    "Italian" -> languageCode = "it"
                }
                  getAPIData().also {
                    it.execute(originalText.text.toString(), languageCode)
                }
            }
        }
    }

    /**
     * tts speaker changes depending on culture chosen
     */
    inner class SpeakButtonClickHandler : View.OnClickListener {
        override fun onClick(v: View) {
            val translatedLanguageSelected =
                translatedSpinner.selectedItem.toString()
            when (translatedLanguageSelected) {
                "English" -> tts.language = Locale.UK
                "French" -> tts.language = Locale.FRENCH
                "Spanish" -> tts.language = Locale("spa", "ESP")
                "German" -> tts.language = Locale.GERMAN
                "Italian" -> tts.language = Locale.ITALIAN
                else -> tts.language = Locale.UK
            }
            tts.speak(this@TranslationActivity.translatedText.text.toString(), TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }

    /**
     * get the requested data from the API
     */
 inner class getAPIData : AsyncTask<String?, Void?, String?>() {
                override fun doInBackground(vararg words: String?): String? {
            var word: String? = null
            try {
                val urlObject = URL(
                    "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20200429T034057Z.6683d7a2c026f967.861f5314981758b4ea6048ad8010ee1b49ff1993&text=" + words[0] + "&lang=" + words[1] + "&options=1"
                )
                val connection =
                    urlObject.openConnection() as HttpURLConnection
                connection.connect()
                val code = connection.responseCode
                if (code == 200) {
                    val `is` = connection.inputStream
                    val ir = InputStreamReader(`is`)
                    val reader = BufferedReader(ir)
                    var currentLine: String?
                    val stringBuilder = StringBuilder()
                    while (reader.readLine().also { currentLine = it } != null) {
                        stringBuilder.append(currentLine)
                    }
                    val data = JSONObject(stringBuilder.toString())
                    val translatedWords = data.getJSONArray("text")
                    word = translatedWords.getString(0)
                    Log.i("Translated word: ", word);
                }
            } catch (e: Exception) {
                Log.i("Error: ", e.message)
            }
            return word
        }

        /**
         * write the word out on the translated TextView
         */
        override fun onPostExecute(word: String?) {
            translatedText.text = word
        }
    }


    /**
     * Navigation class
     */
    inner class OnNavigationItemSelectedListener : BottomNavigationView.OnNavigationItemSelectedListener{
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            return when (item.itemId){
                /**
                 * navigates to the MainActivity
                 */
                R.id.navigation_home -> {
                    startActivity(Intent(this@TranslationActivity, MainActivity::class.java))
                    finish()
                    true
                }
                /**
                 * navigates to the About Us activity
                 */
                R.id.navigation_aboutus ->{
                    startActivity(Intent(this@TranslationActivity, AboutUsActivity::class.java))
                    finish()
                    true
                }
                /**
                 * navigates to the About Us activity
                 */
                R.id.navigation_playquiz->{
                    startActivity(Intent(this@TranslationActivity, TranslationActivity::class.java))
                    finish()
                    true
                }
                /**
                 * navigates to the Contact Us activity
                 */
                R.id.navigation_contactus->{
                    startActivity(Intent(this@TranslationActivity, ContactUsActivity::class.java))
                    finish()
                    true
                }
                else -> onNavigationItemSelected(item)
            }

        }

    }
}
