package com.example.jongdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jongdi.databinding.ActivityOrderDrinkBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OrderDrink : AppCompatActivity() {
    private lateinit var binding: ActivityOrderDrinkBinding
    var productList = arrayListOf<ProductClass>()
    var createClient = ProductAPI.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDrinkBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //link to recy
        binding.recyclerViewDrink.adapter = ProductAdapter(this.productList, applicationContext)
        binding.recyclerViewDrink.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerViewDrink.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerViewDrink.getContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        //add std button
        binding.btnAdddrink.setOnClickListener {
            val intent = Intent(applicationContext, InsertDrink::class.java)
            startActivity(intent)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //ปุ่มกลับ
    }

    override fun onResume() {
        super.onResume()
        callDrinkData()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //ปุ่มกลับ
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun callDrinkData() {
        productList.clear();
        val serv: ProductAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductAPI::class.java)

        serv.retrieveproduct()
            .enqueue(object : Callback<List<ProductClass>> {
                override fun onResponse(
                    call: Call<List<ProductClass>>,
                    response: Response<List<ProductClass>>
                ) {
                    response.body()?.forEach {
                        productList.add(
                            ProductClass(
                                it.Product_ID,
                                it.ProductName,
                                it.ProductType_ID,
                                it.Admin_ID,
                                it.Price
                            )
                        )
                    }
                    //setdatato recycle
                    binding.recyclerViewDrink.adapter =
                        ProductAdapter(productList, applicationContext)
                    binding.txtdrink.text = "Drink List : " + productList.size.toString()
                }

                override fun onFailure(call: Call<List<ProductClass>>, t: Throwable) {
                    Toast.makeText(
                        applicationContext, "Error onFailure" + t.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }
}