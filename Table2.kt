package com.example.jongdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.jongdi.databinding.ActivityTable2Binding
import com.example.jongdi.databinding.ActivityTableBinding

class Table2 : AppCompatActivity() {
    private lateinit var bindingSecond : ActivityTable2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingSecond = ActivityTable2Binding.inflate(layoutInflater)
        setContentView(bindingSecond.root)

        // อ่านข้อมูลจาก Intent
        val date = intent.getStringExtra("date")
        val time = intent.getStringExtra("time")
        val name = intent.getStringExtra("name")
        val table = intent.getStringExtra("table")

        // แสดงข้อมูลบน TextView หรืออื่นๆ
        bindingSecond.txttable.text = "โต๊ะ: ${table}"
        bindingSecond.txtday.text = "วันที่: ${date}"
        bindingSecond.txttime.text = "เวลา: ${time}"
        bindingSecond.txtnamee.text = "ชื่อ: ${name}"


        bindingSecond.pay.setOnClickListener{
            val intent = Intent(applicationContext, openTablewithfood::class.java)
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