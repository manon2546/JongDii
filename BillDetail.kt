package com.example.jongdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jongdi.databinding.ActivityAdminBinding
import com.example.jongdi.databinding.ActivityBillDetailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BillDetail : AppCompatActivity() {
    private lateinit var binding: ActivityBillDetailBinding
    var billdetailList = arrayListOf<BillDetailClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBillDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //link to recycle
        binding.recyclerViewbilldetail.adapter = BillDetailAdapter(this.billdetailList,applicationContext)
        binding.recyclerViewbilldetail.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerViewbilldetail.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerViewbilldetail.getContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        val addBillDetailButton = findViewById<Button>(R.id.btnAddBilldetail)
        addBillDetailButton.setOnClickListener {
            val intent = Intent(this, InsertBillDetail::class.java)
            startActivity(intent)
        }
        binding.billdone.setOnClickListener {
            val intent = Intent(applicationContext, Bill::class.java)
            startActivity(intent)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //ปุ่มกลับ
    }

    override fun onResume() {
        super.onResume()
        callBillDetailData()
    }

    private fun callBillDetailData() {
        billdetailList.clear();
        val serv: BillDetailAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BillDetailAPI::class.java)

        serv.retrievebilldetail()
            .enqueue(object : Callback<List<BillDetailClass>> {
                override fun onResponse(
                    call: Call<List<BillDetailClass>>,
                    response: Response<List<BillDetailClass>>
                ) {
                    response.body()?.forEach {
                        billdetailList.add(
                            BillDetailClass(
                                it.Bill_ID,
                                it.Product_ID,
                                it.Amount,
                                it.Price
                            )
                        )
                    }
                    //set data recycle
                    binding.recyclerViewbilldetail.adapter =
                        BillDetailAdapter(billdetailList, applicationContext)
                    binding.txtList.text = "Bill Item List : " + billdetailList.size.toString()
                }

                override fun onFailure(call: Call<List<BillDetailClass>>, t: Throwable) {
                    Toast.makeText(
                        applicationContext, "Error onFailure" + t.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //ปุ่มกลับ
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}

