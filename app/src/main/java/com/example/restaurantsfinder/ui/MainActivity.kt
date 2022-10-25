package com.example.restaurantsfinder.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantsfinder.R
import com.example.restaurantsfinder.Resource
import com.example.restaurantsfinder.adapter.BusinessAdapter
import com.example.restaurantsfinder.databinding.ActivityMainBinding
import com.example.restaurantsfinder.repository.BusinessDataRepository
import com.example.restaurantsfinder.viewmodel.MainViewModel
import com.example.restaurantsfinder.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var viewmodel:MainViewModel
    lateinit var adapter: BusinessAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val repository = BusinessDataRepository()
        val viewModelProviderFactory = MainViewModelFactory(repository)
        viewmodel = ViewModelProvider(this,viewModelProviderFactory).get(MainViewModel::class.java)

        adapter = BusinessAdapter(this)
        binding.rvBusiness.layoutManager = LinearLayoutManager(this)
        binding.rvBusiness.adapter = adapter
        viewmodel.getBusinessDataObserver().observe(this, Observer {response->
            when(response){
                is Resource.Loading->{
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success ->{
                    binding.progressBar.visibility = View.GONE
                    response.data?.let {
                        //Toast.makeText(this,it.total.toString(),Toast.LENGTH_SHORT).show()
                        it.businesses?.let { it1 -> adapter.setUpdatedData(it1) }
                    }
                }
                is Resource.Error ->{
                    binding.progressBar.visibility = View.GONE
                }
            }
        })

        binding.rvBusiness.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val layoutManager:LinearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
                var totalItemCount = layoutManager?.itemCount
                var lastVisible = layoutManager.findLastVisibleItemPosition()
                val endHasBeenReached:Boolean = lastVisible + 1 ==totalItemCount
                if (totalItemCount > 0 && endHasBeenReached){
                    viewmodel.offset.value = viewmodel.offset.value?.plus(15)
                    viewmodel.getBusinessData("Bearer AETf0M89wj4HcNMbcXdDla46JPbjWoY8WXx26-mzRmFejOPdPa-7P1HTkID8EjyZad1qw8kWkaipYNIiUEg6ArsygnBn4JN4S00fT9WNwx-8S9H_5p8hl2sT6aLWYnYx",
                        "restaurants","NYC",viewmodel.radius.value!!,"distance","15", viewmodel.offset.value!!
                    )
                }
            }
        })
        binding.simpleSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.minBar.text = p1.toString()+"m"
                viewmodel.offset.value = 0
                viewmodel.radius.value = p1
                println(p1)
                adapter.clearData()
                viewmodel.getBusinessData("Bearer AETf0M89wj4HcNMbcXdDla46JPbjWoY8WXx26-mzRmFejOPdPa-7P1HTkID8EjyZad1qw8kWkaipYNIiUEg6ArsygnBn4JN4S00fT9WNwx-8S9H_5p8hl2sT6aLWYnYx",
                    "restaurants","NYC",viewmodel.radius.value!!,"distance","15", viewmodel.offset.value!!
                )
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }
}