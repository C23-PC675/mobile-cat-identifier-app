package com.dicoding.catidentifierapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.catidentifierapp.databinding.ActivityMainBinding

class Main : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this, Home::class.java))


//        Handler(Looper.getMainLooper()).postDelayed({
//            finish()
//        }, 3000)
    }
}