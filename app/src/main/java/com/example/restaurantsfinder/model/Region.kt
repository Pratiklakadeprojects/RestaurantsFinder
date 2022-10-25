package com.example.restaurantsfinder.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Region {
    @SerializedName("center")
    @Expose
    private val center: Center? = null

}