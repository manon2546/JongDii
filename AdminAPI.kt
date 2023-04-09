package com.example.jongdi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface AdminAPI {
    @GET("alladmin")
    fun retrieveadmin(): Call<List<AdminClass>>

    @GET("admin/{AdminID}")
    fun  retrieveAdminID(
        @Path("AdminID") ad_id: String
    ): Call<AdminClass>

    @FormUrlEncoded
    @POST("admin/{AdminID}")
    fun  updateAdmin(
        @Path("AdminID") ad_id: String,
        @Field("AdUser") ad_user: String,
        @Field("Adpassword") ad_pass: String
    ): Call<AdminClass>

    @FormUrlEncoded
    @POST("admin")
    fun insertadmin(
//        @Path("AdminID") ad_id: String,
        @Field("AdUser") ad_user: String,
        @Field("Adpassword") ad_pass: String
    ): Call<AdminClass>

    @DELETE("std/{std_id}")
    fun  deleteAdmin(
        @Path("AdminID") std_id: String
    ):Call<AdminClass>


    companion object{
        fun create(): AdminAPI{
            val adminClient: AdminAPI = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AdminAPI::class.java)
            return adminClient
        }
    }

}