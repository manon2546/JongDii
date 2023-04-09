package com.example.jongdi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jongdi.databinding.ActivityDrinkLayoutBinding
import com.example.jongdi.databinding.AdminItemLayoutBinding

class ProductAdapter (val productList: ArrayList<ProductClass>?, val context: Context):
    RecyclerView.Adapter<ProductAdapter.ViewHolder>(){
    inner class ViewHolder (view: View, val binding: ActivityDrinkLayoutBinding) :
        RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityDrinkLayoutBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return  ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding

        binding.txtband.text = "Name: " + productList!![position].ProductName
        binding.txtprice.text = "Price: " + productList!![position].Price
        binding.txtid.text = "ID: " + productList!![position].Product_ID
    }

    override fun getItemCount(): Int {
        return  productList!!.size
    }
}
