package com.dicoding.catidentifierapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatData(
    val name: String,
    val description: String,
    val photoUrl: String
) : Parcelable

val catList = arrayListOf(
    CatData(
        name = "Whiskers",
        description = "Whiskers is a playful and curious cat. He loves to explore new places and play with toys.",
        photoUrl = "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg"
    ),
    CatData(
        name = "Salem",
        description = "Salem is a mysterious black cat with mesmerizing eyes. He enjoys lounging in sunspots and observing his surroundings.",
        photoUrl = "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg"
    ),
    CatData(
        name = "Mittens",
        description = "Mittens is a fluffy white cat with adorable pink paws. She is very friendly and loves to cuddle with her human companions.",
        photoUrl = "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg"
    ),
    CatData(
        name = "Simba",
        description = "Simba is a regal orange tabby cat with a majestic presence. He enjoys napping and being the center of attention.",
        photoUrl = "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg"
    ),
    CatData(
        name = "Luna",
        description = "Luna is a graceful and elegant cat with sleek black fur. She is independent but also enjoys gentle affection from her humans.",
        photoUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Orange_tabby_cat_sitting_on_fallen_leaves-Hisashi-01A.jpg/800px-Orange_tabby_cat_sitting_on_fallen_leaves-Hisashi-01A.jpg"
    )
)