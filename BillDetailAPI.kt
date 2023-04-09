package com.example.jongdi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface BillDetailAPI {
    @GET("allbilldetail")
    fun retrievebilldetail(): Call<List<BillDetailClass>>

    @FormUrlEncoded
    @POST("billdetail")
    fun insertbilldetail(
        @Path("Bill_ID") Bill_ID: Int,
        @Field("Product_ID ") Product_ID: Int,
        @Field("Amount") Amount: Int,
        @Field("Price") Price: Int
    ): Call<BillDetailClass>

    companion object{
        fun create(): BillDetailAPI{
            val BillDetailClient: BillDetailAPI = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BillDetailAPI::class.java)
            return BillDetailClient
        }
    }
}