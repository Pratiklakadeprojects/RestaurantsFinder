package com.example.restaurantsfinder.repository

import com.example.restaurantsfinder.model.BusinessData
import com.example.restaurantsfinder.network.ApiClient
import com.example.restaurantsfinder.network.ApiInterface
import retrofit2.Response

class BusinessDataRepository() {

    suspend fun getBusinessData(authToken:String,term:String,location:String,radius:Int,sort_by:String,limit:String,offset:Int): Response<BusinessData> {
        val retroInstance = ApiClient.getRetroInstance().create(ApiInterface::class.java)
        return retroInstance.getBusinessData(authToken,term,"37.786882","-122.399972",radius,sort_by,limit,offset)
    }
}