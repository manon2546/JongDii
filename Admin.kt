package com.example.jongdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View.inflate
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jongdi.databinding.ActivityAdminBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Admin : AppCompatActivity() {
    private lateinit var binding: ActivityAdminBinding
    var adminList = arrayListOf<AdminClass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //link to Recycle
        binding.recyclerView.adapter = AdminAdapter(this.adminList, applicationContext)
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.getContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        val addproductButton = findViewById<Button>(R.id.btnaddproduct)
        addproductButton.setOnClickListener {
            val intent = Intent(this, InsertDrink::class.java)
            startActivity(intent)
        }

        val watchpro = findViewById<Button>(R.id.watchproduct)
        watchpro.setOnClickListener {
            val intent = Intent(this, OrderDrink::class.java)
            startActivity(intent)
        }

        //add std button
        binding.btnAddAddmin.setOnClickListener {
            val intent = Intent(applicationContext, InsertAdminActivity::class.java)
            startActivity(intent)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //ปุ่มกลับ
    }
    override fun onResume() {
        super.onResume()
        callAdminData()
    }
        private fun callAdminData() {
            adminList.clear();
            val serv: AdminAPI = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AdminAPI::class.java)

            serv.retrieveadmin()
                .enqueue(object : Callback<List<AdminClass>> {
                    override fun onResponse(
                        call: Call<List<AdminClass>>,
                        response: Response<List<AdminClass>>
                    ) {
                        response.body()?.forEach {
                            adminList.add(AdminClass(it.ad_id, it.ad_user, it.ad_pass))
                        }
                        //setdatato recycle
                        binding.recyclerView.adapter = AdminAdapter(adminList, applicationContext)
                        binding.txtList.text = "Admin List : " + adminList.size.toString()
                    }

                    override fun onFailure(call: Call<List<AdminClass>>, t: Throwable) {
                        Toast.makeText(
                            applicationContext, "Error onFailure" + t.message,
                            Toast.LENGTH_LONG
                        ).show()
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

