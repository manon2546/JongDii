package com.example.jongdi

import retrofit2.Call
import retrofit2.http.*

interface ReserveAPI {
    @GET("allreserve")
    fun retrievereserve(): Call<List<ReserveClass>>

    @FormUrlEncoded
    @POST("reserve")
    fun insertreserve(
        @Path("Reserve_ID") Reserve_ID: String,
        @Field("User_ID") User_ID: String,
        @Field("Status") Status: Int,
        @Field("history") history: Int,
    ): Call<ReserveClass>
}