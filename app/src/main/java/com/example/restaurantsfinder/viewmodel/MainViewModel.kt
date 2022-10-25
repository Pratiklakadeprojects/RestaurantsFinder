package com.example.restaurantsfinder.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurantsfinder.Resource
import com.example.restaurantsfinder.model.BusinessData
import com.example.restaurantsfinder.repository.BusinessDataRepository
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(
    val repository:BusinessDataRepository
): ViewModel() {
    var businessDataLiveData: MutableLiveData<Resource<BusinessData>> = MutableLiveData()
    var offset:MutableLiveData<Int> = MutableLiveData()
    var radius:MutableLiveData<Int> = MutableLiveData()
    fun getBusinessDataObserver():MutableLiveData<Resource<BusinessData>>{
        return businessDataLiveData
    }

    init {
        offset.value = 0
        radius.value = 100
        getBusinessData("Bearer AETf0M89wj4HcNMbcXdDla46JPbjWoY8WXx26-mzRmFejOPdPa-7P1HTkID8EjyZad1qw8kWkaipYNIiUEg6ArsygnBn4JN4S00fT9WNwx-8S9H_5p8hl2sT6aLWYnYx",
            "restaurants","NYC",radius.value!!,"distance","15", offset.value!!
        )
    }

    fun getBusinessData(authToken:String,term:String,location:String,radius:Int,sort_by:String,limit:String,offset:Int) {
        viewModelScope.launch(Dispatchers.IO) {
            businessDataLiveData.postValue(Resource.Loading())
            val response:Response<BusinessData> = repository.getBusinessData(authToken,term,location,radius,sort_by,limit,offset)
            businessDataLiveData.postValue(handleResponse(response))
        }
    }

    private fun handleResponse(response: Response<BusinessData>): Resource<BusinessData> {
        if (response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

}