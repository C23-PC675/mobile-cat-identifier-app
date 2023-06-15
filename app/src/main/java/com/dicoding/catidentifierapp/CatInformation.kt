package com.dicoding.catidentifierapp

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.catidentifierapp.databinding.ActivityCatInformationBinding

class CatInformation : AppCompatActivity() {
    private lateinit var binding: ActivityCatInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cat = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("CAT", CatData::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("CAT")
        }

        if (cat != null) {
            binding.name.text = cat.name
            binding.overview.text = cat.description
            Glide.with(binding.image.context).load(cat.photoUrl)
                .into(binding.image)
        }
    }
}