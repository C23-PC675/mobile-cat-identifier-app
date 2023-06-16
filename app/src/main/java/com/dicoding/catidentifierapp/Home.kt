package com.dicoding.catidentifierapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.catidentifierapp.databinding.ActivityHomeBinding

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
        mainViewModel.cats.observe(this) {
            setCats(it)
        }

        binding.AllScreen.setOnClickListener {
            val intent = Intent(this, CatsList::class.java)
            startActivity(intent)
        }

        binding.PopularScreen.setOnClickListener {
            val intent = Intent(this, CatsListPopular::class.java)
            startActivity(intent)
        }

        binding.RecentScreen.setOnClickListener {
            val intent = Intent(this, CatsListRecent::class.java)
            startActivity(intent)
        }

        binding.FavoriteScreen.setOnClickListener {
            val intent = Intent(this, CatsListFavorite::class.java)
            startActivity(intent)
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    true
                }

                R.id.Settings -> {
                    val intent = Intent(this, Setting::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
    }

    private fun setCats(cats: List<ResponseItem>) {
        val adapter = CatListAdapter(cats)
        binding.recyclerView.adapter = adapter
    }
}