package com.example.androilogictic.Sreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androilogictic.Adapter.RowCompleteOrderAdapter
import com.example.androilogictic.Adapter.RowOrderAdapter
import com.example.androilogictic.Model.CompleteOrder
import com.example.androilogictic.Model.Order
import com.example.androilogictic.Model.Product
import com.example.androilogictic.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class OrderSreen : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private  lateinit var newArrayList: ArrayList<Order>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_sreen)


        fun navigateToScreen(destinationClass: Class<*>) {
            val intent = Intent(this, destinationClass)
            startActivity(intent)
        }
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

        newArrayList = arrayListOf(
            Order( "1","Name1", "Phone1", 100, "Area1","Chờ",10),
            Order("2","Name2", "Phone2", 200, "Area2","Chờ",10),
            Order( "3","Name3", "Phone3", 150, "Area3","Chờ",10),
            Order( "4","Name3", "Phone3", 150, "Area3","Chờ",10)
        )
        val productList = arrayListOf(
            Product("Product 1", "Product 1","shop",10,"url"),
            Product("Product 1", "Product 2","shop",10,"url"),
            Product("Product 1", "Product 3","shop",10,"url")

        )

        newRecyclerView = findViewById(R.id.recyclerOrder)
        newRecyclerView.setHasFixedSize(true)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        val orderAdt = RowOrderAdapter(newArrayList)
        newRecyclerView.adapter  = orderAdt
        orderAdt.onClick ={
            val bottomSheet = BottomSheet.newInstance(productList,it)
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
    }
}