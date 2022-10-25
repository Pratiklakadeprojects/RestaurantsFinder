package com.example.restaurantsfinder.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restaurantsfinder.R
import com.example.restaurantsfinder.model.Business
import com.squareup.picasso.Picasso

class BusinessAdapter(val context: Context): RecyclerView.Adapter<BusinessAdapter.MyViewHolder>() {
    var items: MutableList<Business> = arrayListOf()

    fun setUpdatedData(items:List<Business>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clearData(){
        this.items.clear()
        notifyDataSetChanged()
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.shop_image)
        val shopName = itemView.findViewById<TextView>(R.id.shop_name)
        val shopDistance = itemView.findViewById<TextView>(R.id.shop_distance)
        val shopStatus = itemView.findViewById<TextView>(R.id.shop_status)
        val txtRange = itemView.findViewById<TextView>(R.id.txt_range)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        items[position]?.imageUrl?.let {
            println("position:"+position)
            println(items[position]?.imageUrl)
            //Picasso.get().load(items[position].imageUrl).into(holder.imageView)
            Glide.with(context)
                .load(items[position].imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.imageView)
        }
        holder.shopName.text = items[position].name
        holder.shopDistance.text = items[position].location?.address1
        if (items[position].isClosed!!){
            holder.shopStatus.text = "Currently OPEN"
        }else{
            holder.shopStatus.text = "Currently CLOSED"
        }
        holder.txtRange.text = items[position].rating.toString()
    }

    override fun getItemCount(): Int {
       return items.size
    }
}