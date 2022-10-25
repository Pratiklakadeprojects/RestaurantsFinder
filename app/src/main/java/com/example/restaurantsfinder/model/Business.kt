package com.example.restaurantsfinder.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Business {
    @SerializedName("id")
    @Expose
    val id: String? = null

    @SerializedName("alias")
    @Expose
    val alias: String? = null

    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("image_url")
    @Expose
    val imageUrl: String? = null

    @SerializedName("is_closed")
    @Expose
    val isClosed: Boolean? = null

    @SerializedName("url")
    @Expose
     val url: String? = null

    @SerializedName("review_count")
    @Expose
     val reviewCount: Int? = null

    @SerializedName("categories")
    @Expose
     val categories: List<Category>? = null

    @SerializedName("rating")
    @Expose
     val rating: Double? = null

    @SerializedName("coordinates")
    @Expose
     val coordinates: Coordinates? = null

    @SerializedName("transactions")
    @Expose
     val transactions: List<String>? = null

    @SerializedName("price")
    @Expose
     val price: String? = null

    @SerializedName("location")
    @Expose
    val location: Location? = null

    @SerializedName("phone")
    @Expose
     val phone: String? = null

    @SerializedName("display_phone")
    @Expose
     val displayPhone: String? = null

    @SerializedName("distance")
    @Expose
     val distance: Double? = null
}