package com.example.jongdi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BillClass(
    @Expose
    @SerializedName("Bill_ID") val Bill_ID: Int,

    @Expose
    @SerializedName("Reserve_ID") val Reserve_ID: Int,

    @Expose
    @SerializedName("TotalPrice") val TotalPrice: Int){}
