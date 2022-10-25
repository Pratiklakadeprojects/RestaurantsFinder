package com.example.restaurantsfinder.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class BusinessData {
    @SerializedName("businesses")
    @Expose
    val businesses: List<Business>? = null

    @SerializedName("total")
    @Expose
    val total: Int? = null

    @SerializedName("region")
    @Expose
    val region: Region? = null

}