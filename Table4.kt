package com.example.jongdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import com.example.jongdi.databinding.ActivityAdminBinding
import com.example.jongdi.databinding.ActivityTable4Binding

class Table4 : AppCompatActivity() {
    private lateinit var binding: ActivityTable4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTable4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val Gotable5 = findViewById<Button>(R.id.gotable5)
        Gotable5.setOnClickListener {
            val intent = Intent(this, Table5::class.java)
            startActivity(intent)

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean { //ปุ่มกลับ
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}