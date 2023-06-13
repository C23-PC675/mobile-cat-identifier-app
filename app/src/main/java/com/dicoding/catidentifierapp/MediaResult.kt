package com.dicoding.catidentifierapp

import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.catidentifierapp.databinding.ActivityMediaResultBinding
import java.io.File

class MediaResult : AppCompatActivity() {
    private lateinit var binding: ActivityMediaResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUriString = intent.getStringExtra("imageUri")

        if (imageUriString != null) {
            val imageUri = Uri.parse(imageUriString)
            binding.preview.setImageURI(imageUri)
        } else {
            val data: Uri? = intent.data
            if (data != null) {
                binding.preview.setImageURI(data)
            }
        }
    }
}