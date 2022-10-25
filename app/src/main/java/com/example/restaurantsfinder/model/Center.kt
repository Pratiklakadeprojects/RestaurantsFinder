package com.example.restaurantsfinder.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Center {
    @SerializedName("longitude")
    @Expose
    private val longitude: Double? = null

    @SerializedName("latitude")
    @Expose
    private val latitude: Double? = null
}