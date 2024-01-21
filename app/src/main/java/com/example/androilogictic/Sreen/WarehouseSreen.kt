package com.example.androilogictic.Sreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androilogictic.Adapter.RowCompleteOrderAdapter
import com.example.androilogictic.Adapter.RowWarehouseAdapter
import com.example.androilogictic.Api.ApiProject
import com.example.androilogictic.Model.Order
import com.example.androilogictic.Model.Product
import com.example.androilogictic.Model.Warehouse
import com.example.androilogictic.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WarehouseSreen : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private   var warehouseList: ArrayList<Warehouse>  = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warehouse_sreen)


        fun navigateToScreen(destinationClass: Class<*>) {
            val intent = Intent(this, destinationClass)
            startActivity(intent)
        }

        val bottomNavView: BottomNavigationView = findViewById(R.id.bottomNavView)
        bottomNavView.setSelectedItemId(R.id.menu_warehouse);
        bottomNavView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_home -> {
                    navigateToScreen(MainSreen::class.java)
                    true
                }
                R.id.menu_warehouse -> {
                    navigateToScreen(WarehouseSreen::class.java)
                    true
                }
                R.id.menu_complete -> {
                    navigateToScreen(CompleteSreen::class.java)
                    true
                }
                R.id.menu_order -> {
                    navigateToScreen(OrderSreen::class.java)
                    true
                }
                R.id.menu_profile -> {
                    navigateToScreen(ProfileSreen::class.java)
                    true
                }

                else -> false
            }
        }
        getMyDataWarehouse()

    }

    //Api
    private fun getMyDataWarehouse(){
        val retroData = ApiProject.RetrofitClient.apiBuilder.getWarehouse()
        retroData.enqueue(object : Callback<ArrayList<Warehouse>> {
            override fun onResponse(call: Call<ArrayList<Warehouse>>, response: Response<ArrayList<Warehouse>>) {
                if (response.isSuccessful) {
                    val Warehouses = response.body()
                    if (Warehouses != null) {
                        for (od : Warehouse in Warehouses) {
                            warehouseList.add(od)
                        }
                        setAdapter(warehouseList)
                    }
                } else {
                    Toast.makeText(applicationContext, "Có lỗi khi lấy dữ liệu từ API", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<ArrayList<Warehouse>>, t: Throwable) {
                Toast.makeText(applicationContext, "Đã xảy ra lỗi: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun setAdapter( list : ArrayList<Warehouse> ){
        newRecyclerView = findViewById(R.id.recyclerWarehouse)
        newRecyclerView.setHasFixedSize(true)
        val WarehouseAdapter = RowWarehouseAdapter(list)
        newRecyclerView.adapter = WarehouseAdapter
        WarehouseAdapter.onClick = {
            val intent = Intent(this, OrderDetailSreen::class.java)
            intent.putExtra("warehouse",it)
            startActivity(intent)
        }
    }

}