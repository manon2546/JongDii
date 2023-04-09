package com.example.jongdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jongdi.databinding.ActivityOpenTablewithfoodBinding
import com.example.jongdi.databinding.ActivityOrderDrinkBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class openTablewithfood : AppCompatActivity() {
    private lateinit var bindingorder : ActivityOrderDrinkBinding
    private lateinit var binding: ActivityOpenTablewithfoodBinding
    var productList = arrayListOf<ProductClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpenTablewithfoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val Gonext = findViewById<Button>(R.id.btnAdd)
        Gonext.setOnClickListener {
            val intent = Intent(this, Table3::class.java)
            startActivity(intent)
        }

        binding.btnReset.setOnClickListener{
            resetbilldetail()
        }
        bindingorder = ActivityOrderDrinkBinding.inflate(layoutInflater)
        //link to recy
        binding.recyclerViewDrink.adapter = ProductAdapter(this.productList,applicationContext)
        binding.recyclerViewDrink.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerViewDrink.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerViewDrink.getContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }
    override fun onResume() {
        super.onResume()
        callDrinkData()
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
                        productList.add(ProductClass(it.Product_ID, it.ProductName, it.ProductType_ID,it.Admin_ID,it.Price))
                    }
                    //setdatato recycle
                    binding.recyclerViewDrink.adapter = ProductAdapter(productList, applicationContext)
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

    private fun addbilldetail() {
        val api: BillDetailAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BillDetailAPI::class.java)
        api.insertbilldetail(3,
            binding.edtidproduct.text.toString().toInt(),
            binding.edtamount.text.toString().toInt(),1

        ).enqueue(object : Callback<BillDetailClass> {
            override fun onResponse(
                call: Call<BillDetailClass>,
                response: Response<BillDetailClass>
            ) {
                if (response.isSuccessful()) {
                    Toast.makeText(applicationContext,"Succesfully Inserted",
                        Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(applicationContext, "Insert Failed",
                        Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<BillDetailClass>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailure" +
                        t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
    private fun  resetbilldetail(){
//        bindingInsert.edtadminId.text?.clear()
        binding.edtidproduct.text?.clear()
        binding.edtidproduct.text?.clear()
    }
}