package com.example.jongdi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.security.KeyStore.PasswordProtection

data class AdminClass(
    @Expose
    @SerializedName("AdminID") val ad_id: String,

    @Expose
    @SerializedName("AdUser") val ad_user: String,

    @Expose
    @SerializedName("Adpassword") val ad_pass: String){}
