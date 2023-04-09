package com.example.jongdi

import retrofit2.Call
import retrofit2.http.*

interface UserAPI {
    @GET("alluser")
    fun retrieveuser(): Call<List<UserClass>>

    @GET("user/{User_ID}")
    fun  retrieveuserID(
        @Path("User_ID") user_id: String
    ): Call<UserClass>

    @FormUrlEncoded
    @POST("user/{User_ID}")
    fun  updateuser(
//        @Path("AdminID") ad_id: String,
        @Field("Username") user_name: String,
        @Field("Adpassword") ad_pass: String
    ): Call<UserClass>

    @FormUrlEncoded
    @POST("adduser")
    fun insertuser(
//        @Path("AdminID") ad_id: String,
        @Field("Username") Username: String,
        @Field("password") password: String,
        @Field("Birthday") Birthday: String,
        @Field("TelephoneNumber") TelephoneNumber: String,
        @Field("Email") Email: String,
    ): Call<UserClass>

}