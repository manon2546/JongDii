package com.example.jongdi

import android.R
import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.jongdi.databinding.ActivityLoginBinding
import com.example.jongdi.databinding.ActivityMainBinding
import org.w3c.dom.Text


class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding : ActivityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val registerButton = findViewById<Button>(R.id.txtforgot)
//        registerButton.setOnClickListener {
//            val intent = Intent(this, register::class.java)
//            startActivity(intent)
//        }


        supportActionBar?.setDisplayHomeAsUpEnabled(true) //ปุ่มกลับ

//        val loginButton = findViewById<Button>(R.id.login_button)
//        loginButton.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean { //ปุ่มกลับ
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}