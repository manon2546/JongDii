package com.example.jongdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button

class ChooseReserve : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_reserve)

        val sungButton = findViewById<Button>(R.id.btnSung)
        sungButton.setOnClickListener {
            val intent = Intent(applicationContext, BillDetail::class.java)
            startActivity(intent)
        }

        val jongButton = findViewById<Button>(R.id.btnJong)
        jongButton.setOnClickListener {
            val intent = Intent(applicationContext, Reserve::class.java)
            startActivity(intent)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true) //ปุ่มกลับ
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean { //ปุ่มกลับ
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun Gohome(v: View) {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}