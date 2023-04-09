package com.example.jongdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.jongdi.databinding.ActivityEditAdminDeleteBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditDeleteAdminActivity : AppCompatActivity() {
    private lateinit var bindingEditDelete: ActivityEditAdminDeleteBinding
    var createClient = AdminAPI.create()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingEditDelete = ActivityEditAdminDeleteBinding.inflate(layoutInflater)
        setContentView(bindingEditDelete.root)

        val mID = intent.getStringExtra("mID")
        val mName = intent.getStringExtra("Name")
        val mPass = intent.getStringExtra("mPass")

        bindingEditDelete.edtId.setText(mID)
        bindingEditDelete.edtId.isEnabled = false
        bindingEditDelete.edtName.setText(mName)
        bindingEditDelete.edtPass.setText(mPass)

        supportActionBar?.setDisplayHomeAsUpEnabled(true) //ปุ่มกลับ
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { //ปุ่มกลับ
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
    fun saveStudent(v: View){
        createClient.updateAdmin(
            bindingEditDelete.edtId.text.toString(),
            bindingEditDelete.edtName.text.toString(),
            bindingEditDelete.edtPass.text.toString()
        ).enqueue(object : Callback<AdminClass> {
            override fun onResponse
                        (call: Call<AdminClass>, response: Response<AdminClass>){
                if (response.isSuccessful){
                    Toast.makeText(applicationContext,"Successfully Updated",
                        Toast.LENGTH_LONG).show()
                    finish()
                }else{
                    Toast.makeText(applicationContext,"Update Failure",
                        Toast.LENGTH_LONG).show()

                }
            }

            override fun onFailure(call: Call<AdminClass>, t: Throwable) {
                Toast.makeText(applicationContext,"Error onFailure"+ t.message,
                    Toast.LENGTH_LONG).show()
            }
        })
    }
    fun deleteAdmin(v: View) {
        val AdminId = bindingEditDelete.edtId.text.toString()
        createClient.deleteAdmin(AdminId)
    }


}
