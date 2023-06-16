package com.dicoding.catidentifierapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.catidentifierapp.databinding.ActivityHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabScanner.setOnClickListener {
            startActivity(Intent(this, MediaSelection::class.java))
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        mainViewModel.getCats()
        mainViewModel.cats.observe(this){
            setStories(it)
        }

    }
    private fun setStories(cats: List<ResponseItem>) {
        val adapter = CatListAdapter(cats)
        binding.recyclerView.adapter = adapter
    }
}