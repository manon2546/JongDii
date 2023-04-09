package com.example.jongdi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ProductAPI {
    @GET("allproduct")
    fun retrieveproduct():
            Call<List<ProductClass>>

    @GET("product/{Product_ID}")
    fun  retrieveuserID(
        @Path("Product_ID") user_id: String
    ): Call<ProductClass>

    @FormUrlEncoded
    @POST("product")
    fun insertproduct(
//        @Path("Product_ID") Product_ID: String,
        @Field("ProductName") ProductName: String,
        @Field("ProductType_ID") ProductType_ID: Int,
        @Field("Admin_ID") Admin_ID: Int,
        @Field("Price") Price: Int
    ): Call<ProductClass>

    @FormUrlEncoded
    @PUT("product/{Product_ID}")
    fun updatepro(
        @Path("Product_ID") Product_ID: String,
        @Field("ProductName") ProductName: String,
        @Field("ProductType_ID") ProductType_ID: Int,
        @Field("Admin_ID") Admin_ID: Int,
        @Field("Price") Price: Int
    ): Call<ProductClass>

    @DELETE("product/{Product_ID}")
    fun deletepro(
        @Path("Product_ID") Product_ID: String
    ): Call<ProductClass>



    companion object {
        fun create(): ProductAPI {
            val proClient: ProductAPI = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProductAPI::class.java)
            return proClient
        }
    }
}