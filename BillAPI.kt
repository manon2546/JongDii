package com.example.jongdi

import retrofit2.Call
import retrofit2.http.*

interface BillAPI {
    @GET("allbill")
    fun retrievebill(): Call<List<BillClass>>

    @FormUrlEncoded
    @POST("bill")
    fun insertproduct(
        @Path("Bill_ID") Product_ID: Int,
        @Field("Reserve_ID") ProductName: Int,
        @Field("TotalPrice") ProductType_ID: Int,
    ): Call<BillClass>

    @GET("bill/{Bill_ID}")
    fun  retrievebillID(
//        @Path("Bill_ID") Bill_ID: Int,
        @Field("Reserve_ID") Reserve_ID: Int
    ): Call<BillClass>

}