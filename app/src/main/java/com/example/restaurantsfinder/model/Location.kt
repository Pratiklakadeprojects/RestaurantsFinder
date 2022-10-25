package com.example.restaurantsfinder.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Location {
    @SerializedName("address1")
    @Expose
     val address1: String? = null

    @SerializedName("address2")
    @Expose
     val address2: String? = null

    @SerializedName("address3")
    @Expose
     val address3: String? = null

    @SerializedName("city")
    @Expose
     val city: String? = null

    @SerializedName("zip_code")
    @Expose
     val zipCode: String? = null

    @SerializedName("country")
    @Expose
     val country: String? = null

    @SerializedName("state")
    @Expose
     val state: String? = null

    @SerializedName("display_address")
    @Expose
     val displayAddress: List<String>? = null
}