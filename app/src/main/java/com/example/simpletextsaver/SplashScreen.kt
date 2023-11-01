package com.example.simpletextsaver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.TranslateAnimation
import com.example.simpletextsaver.databinding.SplashScreenBinding

class SplashScreen : AppCompatActivity() {
    lateinit var binding:SplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=SplashScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //for full screen in SplashScreen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        runSplash()

    }

    private fun runSplash() {
        //run SplashScreen
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, 2700)

    }
    private fun translateAnimation() {
        val animTranslate = TranslateAnimation(
            0f,0f,
            -500f,-50f)
        animTranslate.duration=3000
        animTranslate.fillAfter=true
        animTranslate.interpolator = DecelerateInterpolator() // high to Low  speed
        binding.txtNameApp.startAnimation(animTranslate)



    }


}