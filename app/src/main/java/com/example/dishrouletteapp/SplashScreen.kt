package com.example.dishrouletteapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dishrouletteapp.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val logoAnim = AnimationUtils.loadAnimation(this,R.anim.logo_anim)
        val textAnim = AnimationUtils.loadAnimation(this,R.anim.text_anim)

        val logo = findViewById<ImageView>(R.id.app_logo)
        val text = findViewById<TextView>(R.id.app_title)

        logo.startAnimation(logoAnim)
        text.startAnimation(textAnim)

        val splashScreenTimeout = 4000
        val mainIntent = Intent(this@SplashScreen, MainActivity::class.java)

        Handler().postDelayed({
            startActivity(mainIntent)
            finish()
        }, splashScreenTimeout.toLong())

    }
}