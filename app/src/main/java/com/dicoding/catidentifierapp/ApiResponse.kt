package com.dicoding.catidentifierapp

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ApiResponse(
    @field:SerializedName("response")
    val response: ArrayList<ResponseItem>
)

@Parcelize
data class ResponseItem(
    @field:SerializedName("catId")
    val catId: Int,

    @field:SerializedName("catDesc")
    val catDesc: String,

    @field:SerializedName("catCare")
    val catCare: String,

    @field:SerializedName("catRaces")
    val catRaces: String,

    @field:SerializedName("catImage")
    val catImage: String

): Parcelable

