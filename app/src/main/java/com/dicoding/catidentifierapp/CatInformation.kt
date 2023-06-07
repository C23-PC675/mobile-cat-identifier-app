package com.dicoding.catidentifierapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.catidentifierapp.databinding.ActivityCatInformationBinding

class CatInformation : AppCompatActivity() {
    private lateinit var binding: ActivityCatInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}