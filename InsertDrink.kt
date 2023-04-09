package com.example.jongdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.isEmpty
import com.example.jongdi.databinding.ActivityDrinkLayoutBinding
import com.example.jongdi.databinding.ActivityInsertAdminBinding
import com.example.jongdi.databinding.ActivityInsertDrinkBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InsertDrink : AppCompatActivity() {
    private lateinit var bindingInsert: ActivityInsertDrinkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingInsert = ActivityInsertDrinkBinding.inflate(layoutInflater)
        setContentView(bindingInsert.root)

        bindingInsert.btnAdd.setOnClickListener{
            adddrink()
        }
        bindingInsert.btnReset.setOnClickListener{
            resetadmin()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //ปุ่มกลับ
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean { //ปุ่มกลับ
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun adddrink(){
        val api: ProductAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductAPI::class.java)
        api.insertproduct(
            bindingInsert.edtproduct.text.toString(),2,2,
            bindingInsert.edtprice.text.toString().toInt()
        ).enqueue(object :Callback<ProductClass>{
            override fun onResponse(call: Call<ProductClass>, response: Response<ProductClass>) {
                if (response.isSuccessful()) {
                    Toast.makeText(applicationContext,"Succesfully Inserted",
                        Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(applicationContext, "Insert Failed",
                        Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ProductClass>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailure" +
                        t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
    fun showDatePickerDialog(v: View) {
        val newDateFragment = Datapicker()
        newDateFragment.show(supportFragmentManager, "Date Picker")
    }
    private fun  resetadmin(){
        bindingInsert.edtproduct.text?.clear()
        bindingInsert.edtprice.text?.clear()
    }
}



