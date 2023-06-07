package com.dicoding.catidentifierapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.catidentifierapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_media_result)
    }
}