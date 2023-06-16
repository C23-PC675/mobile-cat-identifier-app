package com.dicoding.catidentifierapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.catidentifierapp.databinding.ActivitySettingBinding

class Setting : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.exit.setOnClickListener {
            finishAffinity()
        }
    }
}