package com.example.jongdi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ReserveClass(
    @Expose
    @SerializedName("Reserve_ID") val Reserve_ID: Int,

    @Expose
    @SerializedName("User_ID") val User_ID: String,

    @Expose
    @SerializedName("Status") val Status: String,

    @Expose
    @SerializedName("history") val history: String){}
