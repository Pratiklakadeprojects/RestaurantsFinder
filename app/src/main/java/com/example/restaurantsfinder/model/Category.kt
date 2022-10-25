package com.example.restaurantsfinder.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Category {
    @SerializedName("alias")
    @Expose
    private var alias: String? = null

    @SerializedName("title")
    @Expose
    private var title: String? = null

}