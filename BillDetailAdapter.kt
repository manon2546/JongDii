package com.example.jongdi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jongdi.databinding.AdminItemLayoutBinding
import com.example.jongdi.databinding.BilldetailItemLayoutBinding

class BillDetailAdapter (val billDetailList: ArrayList<BillDetailClass>?,val context: Context):
    RecyclerView.Adapter<BillDetailAdapter.ViewHolder>() {

    inner class ViewHolder(view: View, val binding: BilldetailItemLayoutBinding) :
        RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BilldetailItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return  ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding

        binding.txtproduct.text = "ID: " + billDetailList!![position].Product_ID
        binding.txtproName.text = "ชื่อสินค้า: " + billDetailList!![position].Bill_ID
        binding.txtpass.text = "ราคา: " + billDetailList!![position].Price
        binding.txtamount.text = "จำนวน: " + billDetailList!![position].Amount
    }

    override fun getItemCount(): Int {
        return billDetailList!!.size
    }
}