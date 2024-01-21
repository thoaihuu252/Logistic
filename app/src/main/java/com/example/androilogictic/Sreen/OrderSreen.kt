package com.example.androilogictic.Sreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androilogictic.Adapter.RowOrderAdapter
import com.example.androilogictic.Api.ApiProject
import com.example.androilogictic.Model.Order
import com.example.androilogictic.Model.Product
import com.example.androilogictic.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class OrderSreen : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private var orderList: ArrayList<Order> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_sreen)
        val bottomNavView: BottomNavigationView = findViewById(R.id.bottomNavView)
        bottomNavView.setSelectedItemId(R.id.menu_order);
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
        val search : ImageButton = findViewById(R.id.btnSearch)
        search.setOnClickListener{
            navigateToScreen(SearchActivity::class.java)
        }
        getMyDataOrder()
    }
    // chuyển tab
    private fun navigateToScreen(destinationClass: Class<*>) {
        val intent = Intent(this, destinationClass)
        startActivity(intent)
    }
    //API
    private fun getMyDataOrder(){
        val retroData = ApiProject.RetrofitClient.apiBuilder.getOrder()
        retroData.enqueue(object : Callback<ArrayList<Order>> {
            override fun onResponse(call: Call<ArrayList<Order>>, response: Response<ArrayList<Order>>) {
                if (response.isSuccessful) {
                    val orders = response.body()
                    if (orders != null) {
                        for (od : Order in orders) {
                            if (od.status.equals("Wait")) {
                                orderList.add(od)
                            }
                        }
                        setAdapter(orderList)
                    }
                } else {
                    Toast.makeText(applicationContext, "Có lỗi khi lấy dữ liệu từ API", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<ArrayList<Order>>, t: Throwable) {
                Toast.makeText(applicationContext, "Đã xảy ra lỗi: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
    // fun Adapter
    private fun setAdapter( list : ArrayList<Order> ){
        newRecyclerView = findViewById(R.id.recyclerOrder)
        newRecyclerView.setHasFixedSize(true)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        val orderAdt = RowOrderAdapter(list)
        newRecyclerView.adapter  = orderAdt
        orderAdt.onClick ={
            val bottomSheet = BottomSheet.newInstance(it.productList as ArrayList<Product>,it)
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }


    }

}