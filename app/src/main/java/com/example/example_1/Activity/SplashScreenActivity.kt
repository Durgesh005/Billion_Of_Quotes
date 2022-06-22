package com.example.example_1.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.example.example_1.R
import com.example.example_1.databinding.ActivitySpalashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivitySpalashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpalashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)



        Handler().postDelayed({
            binding.animationView.playAnimation()
            val intent = Intent(this, MainActivity::class.java)
            binding.animationView.pauseAnimation()
            startActivity(intent)
            finish()
        }, 2500)
    }
}