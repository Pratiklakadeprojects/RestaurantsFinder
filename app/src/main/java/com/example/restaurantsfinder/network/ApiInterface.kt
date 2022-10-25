package com.example.restaurantsfinder.network

import com.example.restaurantsfinder.model.BusinessData
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiInterface {

    @GET("businesses/search")
    suspend fun getBusinessData(@Header("Authorization") Authorization:String,
                                @Query("term") term:String,
                                @Query("latitude") latitude:String,
                                @Query("longitude") longitude:String,
                                @Query("radius") radius:Int,
                                @Query("sort_by") sort_by:String,
                                @Query("limit") limit:String,
                                @Query("offset") offset:Int

    ):Response<BusinessData>

}