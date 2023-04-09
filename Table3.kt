package com.example.jongdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import com.example.jongdi.databinding.ActivityTable3Binding
import com.example.jongdi.databinding.ActivityTableBinding

class Table3 : AppCompatActivity() {
    private lateinit var binding: ActivityTable3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTable3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val gotable4 = findViewById<Button>(R.id.yes)
        gotable4.setOnClickListener {
            val intent = Intent(this, Table4::class.java)
            startActivity(intent)

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding.no.setOnClickListener {
            val intent = Intent(applicationContext, ChooseReserve::class.java)
            startActivity(intent)
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean { //ปุ่มกลับ
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}