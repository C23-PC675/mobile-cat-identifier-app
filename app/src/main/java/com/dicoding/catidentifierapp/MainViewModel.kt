package com.dicoding.catidentifierapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    private val _cats = MutableLiveData<List<ResponseItem>>()
    val cats: LiveData<List<ResponseItem>> = _cats

    fun getCats() {
        val client = ApiConfig.getApiService().getCats()
        client.enqueue(object : Callback<List<ResponseItem>> {
            override fun onResponse(call: Call<List<ResponseItem>>, response: Response<List<ResponseItem>>) {
                if (response.isSuccessful) {
                    try {
                        _cats.value = response.body()
                        Log.i("Get Cats", " : ${response.message()}")
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                } else {
                    Log.e("Get Cats", "Response error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                Log.e("Get Cats", "Error: ${t.message}")
            }

        })
    }
}