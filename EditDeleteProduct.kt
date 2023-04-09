package com.example.jongdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.jongdi.databinding.ActivityEditDeleteProductBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditDeleteProduct : AppCompatActivity() {
    private lateinit var bindingEditDelete: ActivityEditDeleteProductBinding
    var createClient = ProductAPI.create()
    var mId : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingEditDelete = ActivityEditDeleteProductBinding.inflate(layoutInflater)
        setContentView(bindingEditDelete.root)

        val mId = intent.getStringExtra("mId").toString()
        val mName = intent.getStringExtra("Name")
        val mProducttype = intent.getStringExtra("Producttype").toString()
        val mAdminId = intent.getStringExtra("AdminId").toString()
        val mPrice = intent.getStringExtra("mAge")

        bindingEditDelete.edtId.setText(mId)
        bindingEditDelete.edtId.isEnabled = false
        bindingEditDelete.edtName.setText(mName)
        bindingEditDelete.edtprotypeId.setText(mProducttype)
        bindingEditDelete.edtprotypeId.isEnabled = false
        bindingEditDelete.edtPrice.setText(mPrice)
        bindingEditDelete.edtadminID.setText(mAdminId)
        bindingEditDelete.edtadminID.isEnabled = false

        supportActionBar?.setDisplayHomeAsUpEnabled(true) //ปุ่มกลับ
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //ปุ่มกลับ
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun saveProduct(v: View) {
        createClient.updatepro(
            bindingEditDelete.edtId.text.toString(),
            bindingEditDelete.edtName.text.toString(),
            bindingEditDelete.edtprotypeId.text.toString().toInt(),
            bindingEditDelete.edtadminID.text.toString().toInt(),
            bindingEditDelete.edtPrice.text.toString().toInt()
        ).enqueue(object : Callback<ProductClass> {
            override fun onResponse(call: Call<ProductClass>, response: Response<ProductClass>) {
                if (response.isSuccessful) {
                    Toast.makeText(applicationContext,"Successfully Updated",
                        Toast.LENGTH_LONG).show()
                    finish()
                }else{
                    Toast.makeText(applicationContext,"Update Failure",
                        Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ProductClass>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailure" + t.message,
                    Toast.LENGTH_LONG).show()
            }
        })
    }
    fun deleteProduct(v: View) {
        val myBuilder = AlertDialog.Builder(this)
        myBuilder.apply {
            setTitle("Warning")
            setMessage("Do you want to delete the Product?")
            setNegativeButton("Yes") { dialog, which ->
                createClient.deletepro(mId)
                    .enqueue(object : Callback<ProductClass> {
                        override fun onResponse(call: Call<ProductClass>, response: Response<ProductClass>) {
                            if (response.isSuccessful) {
                                Toast.makeText(applicationContext, "Successfully Deleted",
                                    Toast.LENGTH_LONG).show()
                            }
                        }
                        override fun onFailure(call: Call<ProductClass>, t: Throwable) {
                            Toast.makeText(applicationContext,"Error onFailure" + t.message,
                                Toast.LENGTH_LONG).show()
                        }
                    })
                finish()
            }
            setPositiveButton ("No"){ dialog, which ->dialog.cancel()}
            show()
        }
    }
}