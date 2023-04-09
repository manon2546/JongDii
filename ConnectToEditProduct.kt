package com.example.jongdi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.jongdi.databinding.ActivityDrinkLayoutBinding
import com.example.jongdi.databinding.ActivityEditDeleteProductBinding

class ConnectToEditProduct : AppCompatActivity() {
    private lateinit var binding: ActivityDrinkLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val addproductButton = findViewById<Button>(R.id.txtEditDelete)
        addproductButton.setOnClickListener {
            val intent = Intent(this, EditDeleteProduct::class.java)
            startActivity(intent)
        }
    }
}




