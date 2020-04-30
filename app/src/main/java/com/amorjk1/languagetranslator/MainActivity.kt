package com.amorjk1.languagetranslator

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //lateinit var mTTs:TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar1)

        /**
         * calling the class OnNavigationItemSelectedListener() to the onCreate() method
         */
        bnv1.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener())
        bnv1.menu.getItem(1).isChecked = true

        //Start/French button takes you to the French quiz
        startButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, PlayScreenActivity::class.java)
            startActivity(intent)
        })

        //german button takes you to german quiz
        btnGerman.setOnClickListener(View.OnClickListener {
            val intentGerman = Intent(this@MainActivity, PlayScreenGermanActivity::class.java)
            startActivity(intentGerman)
        })

        /*
        Button, spanish takes you to spanish quiz
         */
        btnSpanish.setOnClickListener(View.OnClickListener {
            val intentSpanish = Intent(this@MainActivity, PlayScreenSpanishActivity::class.java)
            startActivity(intentSpanish)
        })

        /*
        button, takes you to Italian Quiz
         */
        btnItalian.setOnClickListener(View.OnClickListener {
            val intentItalian = Intent(this@MainActivity, PlayScreenItalianActivity::class.java)
            startActivity(intentItalian)
        })
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
             * navigates to the SettingsActivity
             */
            R.id.action_settings -> {
                startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /*
    exit alert dialog on back pressed, when user presses back button
    gives user option to to exit "yes" or stay "no"
     */
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Are You Sure You want To Exit")
            .setCancelable(false)
            .setPositiveButton("Yes", { dialog, id-> super@MainActivity.onBackPressed() })
            .setNegativeButton("No", null)
            .show()
    }
    
    inner class OnNavigationItemSelectedListener : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                /**
                 * navigates to the MainActivity
                 */
                R.id.navigation_home -> {
                    startActivity(Intent(this@MainActivity, MainActivity::class.java))
                    finish()
                    true
                }
                /**
                 * navigates to the About Us activity
                 */
                R.id.navigation_aboutus -> {
                    startActivity(Intent(this@MainActivity, AboutUsActivity::class.java))
                    finish()
                    true
                }
                /**
                 * navigates to the About Us activity
                 */
                R.id.navigation_playquiz->{
                    startActivity(Intent(this@MainActivity, TranslationActivity::class.java))
                    finish()
                    true
                }
                /**
                 * navigates to the Contact Us activity
                 */
                R.id.navigation_contactus->{
                    startActivity(Intent(this@MainActivity, ContactUsActivity::class.java))
                    finish()
                    true
                }
                else -> onNavigationItemSelected(item)
            }
        }
    }
}
