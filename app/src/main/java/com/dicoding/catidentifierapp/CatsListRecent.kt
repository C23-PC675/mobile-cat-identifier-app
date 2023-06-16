package com.dicoding.catidentifierapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.catidentifierapp.databinding.ActivityCatsListRecentBinding

class CatsListRecent : AppCompatActivity() {
    private lateinit var binding: ActivityCatsListRecentBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatsListRecentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        mainViewModel.getCats()
        mainViewModel.cats.observe(this) {
            setCats(it)
        }

        binding.back.setOnClickListener {
            finish()
        }
    }

    private fun setCats(cats: List<ResponseItem>) {
        val adapter = CatListAdapter(cats)
        binding.recyclerView.adapter = adapter
    }
}