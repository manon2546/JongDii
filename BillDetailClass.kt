package com.example.jongdi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BillDetailClass(
    @Expose
    @SerializedName("Bill_ID") val Bill_ID: Int,

    @Expose
    @SerializedName("Product_ID") val Product_ID: Int,

    @Expose
    @SerializedName("Amount") val Amount: Int,

    @Expose
    @SerializedName("Price") val Price: Int){}
