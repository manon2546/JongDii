package com.example.jongdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.btnlogin)
        loginButton.setOnClickListener {
            val intent = Intent(this, ChooseReserve::class.java)
            startActivity(intent)
        }
        val loginADMINButton = findViewById<Button>(R.id.btnloginadmin)
        loginADMINButton.setOnClickListener {
            val intent = Intent(this, Admin::class.java)
            startActivity(intent)
        }

        val registerButton = findViewById<Button>(R.id.btnregis)
        registerButton.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }
//        supportActionBar?.setDisplayHomeAsUpEnabled(true) //ปุ่มกลับ
    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean { //ปุ่มกลับ
//        if (item.itemId == android.R.id.home){
//            finish()
//        }
//        return super.onOptionsItemSelected(item)
//    }
}