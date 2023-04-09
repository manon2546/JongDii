package com.example.jongdi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductClass(
    @Expose
    @SerializedName("Product_ID") val Product_ID: Int,

    @Expose
    @SerializedName("ProductName") val ProductName: String,

    @Expose
    @SerializedName("ProductType_ID") val ProductType_ID: Int,

    @Expose
    @SerializedName("Admin_ID") val Admin_ID: Int,

    @Expose
    @SerializedName("Price") val Price: Int){}
