package com.dicoding.catidentifierapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.catidentifierapp.databinding.ActivityMediaSelectionBinding

class MediaSelection : AppCompatActivity() {
    private lateinit var binding: ActivityMediaSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}