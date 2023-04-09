package com.example.jongdi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jongdi.databinding.ActivityDrinkLayoutBinding
import com.example.jongdi.databinding.ActivityEditDeleteProductBinding

class EditProductAdapter (val items : List<ProductClass>,val context: Context):
    RecyclerView.Adapter<EditProductAdapter.ViewHolder>(){
    inner class ViewHolder (view: View, val binding: ActivityDrinkLayoutBinding):
        RecyclerView.ViewHolder(view){
        init {
            binding.txtEditDelete.setOnClickListener {
                val item = items[adapterPosition]
                val contextView: Context = view.context
                val intent = Intent(contextView, ActivityEditDeleteProductBinding::class.java)
                intent.putExtra("mId",item.Product_ID)
                intent.putExtra("mName",item.ProductName)
                intent.putExtra("Producttype",item.ProductType_ID.toString())
                intent.putExtra("AdminId",item.Admin_ID.toString())
                intent.putExtra("mPrice",item.Price.toString())
                contextView.startActivity(intent)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityDrinkLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false)
        return  ViewHolder(binding.root, binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding_holder = holder.binding
        binding_holder.txtid.text = items[position].Product_ID.toString()
        binding_holder.txtband.text = items[position].ProductName
        binding_holder.txtprice.text = items[position].Price.toString()
    }

    override fun getItemCount(): Int {
        return  items.size
    }

}