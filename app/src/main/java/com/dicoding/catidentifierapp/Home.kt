package com.dicoding.catidentifierapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.catidentifierapp.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}