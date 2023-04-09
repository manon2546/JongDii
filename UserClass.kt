package com.example.jongdi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Date

data class UserClass(

    @Expose
    @SerializedName("User_ID") val user_id: Int,

    @Expose
    @SerializedName("Username") val Username: String,

    @Expose
    @SerializedName("password") val password: String,

    @Expose
    @SerializedName("Birthday") val Birthday: String,

    @Expose
    @SerializedName("TelephoneNumber") val TelephoneNumber: String,

    @Expose
    @SerializedName("Email") val Email: String){}
