package com.example.jongdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.jongdi.databinding.ActivityAfterBillBinding
import com.example.jongdi.databinding.ActivityBillBinding

class Bill : AppCompatActivity() {
    private lateinit var binding: ActivityBillBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBillBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.yes.setOnClickListener {
            val intent = Intent(applicationContext, AfterBill::class.java)
            startActivity(intent)
        }
        binding.no.setOnClickListener {
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
}