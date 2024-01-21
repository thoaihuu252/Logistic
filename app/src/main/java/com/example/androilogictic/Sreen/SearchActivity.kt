package com.example.androilogictic.Sreen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androilogictic.Api.ApiProject
import com.example.androilogictic.Model.Order
import com.example.androilogictic.R
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchActivity : AppCompatActivity() {
    private var searchList:  ArrayList<Order?>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val btnSearch  = findViewById<ImageButton>(R.id.btnSearch)
        val txtSearch = findViewById<TextInputEditText>(R.id.txtSearch)
        val intent = Intent()

        btnSearch.setOnClickListener {
            val txt = txtSearch.text.toString()
            searchByName(txt)
            intent.putExtra("searchResult", searchList as ArrayList<Order>)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
    private fun searchByName(text : String) {
        val retroData = ApiProject.RetrofitClient.apiBuilder.searchOrdersByName(text);
        retroData?.enqueue(object : Callback<ArrayList<Order?>?> {
            override fun onResponse(call: Call<ArrayList<Order?>?>?, response: Response<ArrayList<Order?>?>?) {
                if (response?.isSuccessful == true) {
                    val orders = response.body()

                    if (orders != null) {
                        searchList?.addAll(orders)
                    }
                } else {
                    Toast.makeText(applicationContext, "Có lỗi khi lấy dữ liệu từ API", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ArrayList<Order?>?>, t: Throwable) {
                Toast.makeText(applicationContext, "Có lỗi ", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

