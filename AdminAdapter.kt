package com.example.jongdi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.jongdi.databinding.AdminItemLayoutBinding

class AdminAdapter (val adminList: ArrayList<AdminClass>?, val context: Context):
    RecyclerView.Adapter<AdminAdapter.ViewHolder>(){

    inner class ViewHolder (view: View, val binding: AdminItemLayoutBinding) :
        RecyclerView.ViewHolder(view){

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdminItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return  ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding

        binding.txtId.text = "ID: " + adminList!![position].ad_id
        binding.txtName.text = "User: " + adminList!![position].ad_user
        binding.txtpass.text = "Password: *********"
    }

    override fun getItemCount(): Int {
        return  adminList!!.size
    }
}