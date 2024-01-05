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
import com.example.androilogictic.R

class OrderSreen : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private  lateinit var newArrayList: ArrayList<Order>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_sreen)
        val warehouse: LinearLayout = findViewById(R.id.buttonWarehouse)
        val home: LinearLayout = findViewById(R.id.buttonHome)
        val order: LinearLayout = findViewById(R.id.buttonOrder)
        val profile: LinearLayout = findViewById(R.id.buttonProfile)
        val complete: LinearLayout = findViewById(R.id.buttonComplete)

        fun navigateToScreen(destinationClass: Class<*>) {
            val intent = Intent(this, destinationClass)
            startActivity(intent)
        }
        warehouse.setOnClickListener { navigateToScreen(WarehouseSreen::class.java) }
        home.setOnClickListener { navigateToScreen(MainSreen::class.java) }
        profile.setOnClickListener { navigateToScreen(ProfileSreen::class.java) }
        order.setOnClickListener { navigateToScreen(OrderSreen::class.java) }
        complete.setOnClickListener { navigateToScreen(CompleteSreen::class.java) }

        newArrayList = arrayListOf(
            Order( "Name1", "Phone1", "$100", "Area1"),
            Order("Name2", "Phone2", "$200", "Area2"),
            Order( "Name3", "Phone3", "$150", "Area3"),
            Order( "Name4", "Phone4", "$180", "Area4"),
            Order("Name5", "Phone5", "$120", "Area5")
        )
        newRecyclerView = findViewById(R.id.recyclerOrder)
        newRecyclerView.setHasFixedSize(true)
        newRecyclerView.layoutManager = LinearLayoutManager(this)

        newRecyclerView.adapter  = RowOrderAdapter(newArrayList)
    }
}