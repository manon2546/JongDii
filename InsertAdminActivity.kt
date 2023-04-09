package com.example.jongdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jongdi.databinding.ActivityInsertAdminBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InsertAdminActivity : AppCompatActivity() {
    private lateinit var bindingInsert : ActivityInsertAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingInsert = ActivityInsertAdminBinding.inflate(layoutInflater)
        setContentView(bindingInsert.root)
        //ADd
        bindingInsert.btnAdd.setOnClickListener{
            addaddmin()
        }
        bindingInsert.btnReset.setOnClickListener{
            resetadmin()
        }
    }
    private fun addaddmin(){
        val api: AdminAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AdminAPI::class.java)
        api.insertadmin(
            bindingInsert.edtadminuser.text.toString(),
            bindingInsert.edtadminpass.text.toString()
            //            bindingInsert.edtadminId.text.toString(),
        ).enqueue(object : Callback<AdminClass> {
            override fun onResponse(call: Call<AdminClass>,
                                    response: retrofit2.Response<AdminClass>
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

            override fun onFailure(call: Call<AdminClass>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailure" +
                        t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun  resetadmin(){
//        bindingInsert.edtadminId.text?.clear()
        bindingInsert.edtadminuser.text?.clear()
        bindingInsert.edtadminpass.text?.clear()
    }
}