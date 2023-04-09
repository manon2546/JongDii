package com.example.jongdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.jongdi.databinding.ActivityAfterBillBinding
import com.example.jongdi.databinding.ActivityReserveBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AfterBill : AppCompatActivity() {
    private lateinit var binding: ActivityAfterBillBinding
    var billList = arrayListOf<BillClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAfterBillBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.return1.setOnClickListener {
            val intent = Intent(applicationContext, ChooseReserve::class.java)
            startActivity(intent)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //ปุ่มกลับ
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //ปุ่มกลับ
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

//    override fun onResume() {
//        super.onResume()
//        callDrinkData()
//    }
//
//    private fun callDrinkData() {
//        billList.clear();
//        val serv: BillAPI = Retrofit.Builder()
//            .baseUrl("http://10.0.2.2:3000/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(BillAPI::class.java)
//
//        serv.retrievebillID()
//            .enqueue(object : Callback<List<BillClass>> {
//                override fun onResponse(
//                    call: Call<List<BillClass>>,
//                    response: Response<List<BillClass>>
//                ) {
//                    response.body()?.forEach {
//                        billList.add(BillClass(it.Bill_ID, it.Reserve_ID, it.TotalPrice))
//                    }
//                    //setdatato recycle
//                    binding.text3.text = "โต๊ะของคุณคือ : " + billList.get()
//                }
//
//                override fun onFailure(call: Call<List<BillClass>>, t: Throwable) {
//                    Toast.makeText(
//                        applicationContext, "Error onFailure" + t.message,
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//            })
//    }
}


