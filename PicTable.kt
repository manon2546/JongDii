package com.example.jongdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class PicTable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pic_table)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //ปุ่มกลับ
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean { //ปุ่มกลับ
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}