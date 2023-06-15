package com.dicoding.catidentifierapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.catidentifierapp.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabScanner.setOnClickListener {
            startActivity(Intent(this, MediaSelection::class.java))
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CatListAdapter(catList)
        binding.recyclerView.adapter = adapter
    }
}