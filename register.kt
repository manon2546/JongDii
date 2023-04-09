package com.example.jongdi

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.jongdi.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class register : AppCompatActivity() {
    private lateinit var bindingInsert : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState )

        bindingInsert = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(bindingInsert.root)
        //ADd
        bindingInsert.btnregister.setOnClickListener{
            adduser()
        }


        supportActionBar?.setDisplayHomeAsUpEnabled(true) //ปุ่มกลับ
    }
    fun showDatePickerDialog(v: View) {
        val newDateFragment = Datapicker()
        newDateFragment.show(supportFragmentManager, "Date Picker")
    }

    private fun adduser(){
        val api: UserAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserAPI::class.java)
        api.insertuser(
            bindingInsert.edtUser.text.toString(),
            bindingInsert.edtnewpass.text.toString(),
            bindingInsert.birthday.text.toString(),
            bindingInsert.edttel.text.toString(),
            bindingInsert.edtemail.text.toString()
        ).enqueue(object : Callback<UserClass> {
            override fun onResponse(call: Call<UserClass>,
                                    response:Response<UserClass>
            ) {
                if (response.isSuccessful()) {
                    Toast.makeText(applicationContext,"Successfully Inserted",
                        Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(applicationContext, "Insert Failed",
                        Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserClass>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailure" +
                        t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean { //ปุ่มกลับ
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}