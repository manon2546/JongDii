package com.example.jongdi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.jongdi.databinding.ActivityTableBinding

class Table : AppCompatActivity() {
    private lateinit var binding: ActivityTableBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityTableBinding.inflate(layoutInflater)
        setContentView((binding.root))

        binding.btnShowDetail.setOnClickListener {
            var table_str: String = " "
            if (binding.table1.isChecked) {
                table_str += " " + "1";
            }
            if (binding.table2.isChecked) {
                table_str += " " + "2";
            }
            if (binding.table3.isChecked) {
                table_str += " " + "3";
            }
            if (binding.table4.isChecked) {
                table_str += " " + "4";
            }
            if (binding.table5.isChecked) {
                table_str += " " + "5";
            }
            if (binding.table6.isChecked) {
                table_str += " " + "6";
            }

            if (binding.table6.isChecked) {
                table_str += " " + "6";
            }
            if (binding.table7.isChecked) {
                table_str += " " + "7";
            }
            if (binding.table8.isChecked) {
                table_str += " " + "8";
            }
            if (binding.table9.isChecked) {
                table_str += " " + "9";
            }
            if (binding.table10.isChecked) {
                table_str += " " + "10";
            }
            if (binding.table11.isChecked) {
                table_str += " " + "11";
            }
            if (binding.table12.isChecked) {
                table_str += " " + "12";
            }
            if (binding.table13.isChecked) {
                table_str += " " + "13";
            }
            if (binding.table14.isChecked) {
                table_str += " " + "14";
            }
            if (binding.table15.isChecked) {
                table_str += " " + "15";
            }
            if (binding.table16.isChecked) {
                table_str += " " + "16";
            }
            if (binding.table17.isChecked) {
                table_str += " " + "17";
            }
            if (binding.table18.isChecked) {
                table_str += " " + "18";
            }
            if (binding.table19.isChecked) {
                table_str += " " + "19";
            }
            if (binding.table20.isChecked) {
                table_str += " " + "20";
            }

            var table_new = if (table_str.isNotEmpty()) table_str else "No table."

            val intent = Intent(this, Table2::class.java)
            intent.putExtra("tableList", table_new)
            startActivity(intent)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean { //ปุ่มกลับ
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}