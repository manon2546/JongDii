package com.example.jongdi//package com.example.jongdi

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.jongdi.R
import com.example.jongdi.databinding.ActivityReserveBinding

class Reserve : AppCompatActivity() {
    private lateinit var binding : ActivityReserveBinding
    private lateinit var dateEditText: EditText
    private lateinit var timeEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var tableEditText: EditText
    private lateinit var confirmButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserve)

        val myImage = findViewById<ImageView>(R.id.mypic)
        myImage.setOnClickListener {
            val intent = Intent(applicationContext, PicTable::class.java)
            startActivity(intent)

        // อ้างอิงไปยัง View ใน layout XML
        dateEditText = findViewById(R.id.booking_date_input)
        timeEditText = findViewById(R.id.booking_time_input)
        nameEditText = findViewById(R.id.booking_name_input)
        tableEditText = findViewById(R.id.edttable)
        confirmButton = findViewById(R.id.booking_button)

        confirmButton.setOnClickListener {
            // ดึงข้อมูลจาก EditText
            val date = dateEditText.text.toString()
            val time = timeEditText.text.toString()
            val name = nameEditText.text.toString()
            val table = tableEditText.text.toString()

            // สร้าง Intent object และเพิ่มข้อมูลเป็น extras
            val intent = Intent(this, Table2::class.java).apply {
                putExtra("date", date)
                putExtra("time", time)
                putExtra("name", name)
                putExtra("table", table)
            }

            // เรียกเปิด Activity ด้วย Intent object ที่สร้างขึ้น
            startActivity(intent)
        }

        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //ปุ่มกลับ
    }
    fun showDatePickerDialog(v: View) {
        val newDateFragment = Datapicker()
        newDateFragment.show(supportFragmentManager, "Date Picker")
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean { //ปุ่มกลับ
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
