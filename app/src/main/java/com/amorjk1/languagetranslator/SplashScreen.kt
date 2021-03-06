package com.amorjk1.languagetranslator
/*
splash screen, first screen user sees when app is launched
 */
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        splash screen duration with animation
         */
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            startActivity(Intent(this@SplashScreen, MainActivity::class.java))
            finish()
        }, resources.getInteger(R.integer.sleep).toLong())

        /*
        splash screen animation
         */
        imvIcons.alpha = 0f
        imvIcons.animate().setDuration(3000).alpha(1f);

        imvText.alpha = 0f
        imvText.animate().setDuration(3000).alpha(1f);
    }
}
