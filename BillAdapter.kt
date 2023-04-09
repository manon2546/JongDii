package com.example.jongdi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jongdi.databinding.ActivityAfterBillBinding
import com.example.jongdi.databinding.AdminItemLayoutBinding

class BillAdapter (val billList: ArrayList<BillClass>? , context: Context){
 inner class ViewHolder (view: View,val binding: ActivityAfterBillBinding)
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BillAdapter.ViewHolder {
        val binding = ActivityAfterBillBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return  ViewHolder(binding.root, binding)
    }

    fun onBindViewHolder(holder: BillAdapter.ViewHolder, position: Int) {
        val binding = holder.binding

        binding.text3.text = "โต๊ะของคุณคือ: " + billList!![position].Reserve_ID
        binding.text4.text = "รายการเครื่องดื่ม : " + billList!![position].Bill_ID
    }
    fun getItemCount(): Int {
        return  billList!!.size
    }
}