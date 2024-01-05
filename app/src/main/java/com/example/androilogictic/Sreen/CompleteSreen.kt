package com.example.androilogictic.Sreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androilogictic.Adapter.RowCompleteOrderAdapter
import com.example.androilogictic.Model.CompleteOrder
import com.example.androilogictic.R

class CompleteSreen : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private  lateinit var newArrayList: ArrayList<CompleteOrder>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_sreen)
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
            CompleteOrder(R.drawable.rectangle_bg_cyan_50_radius_10, "Name1", "Phone1", "$100", "Area1"),
            CompleteOrder(R.drawable.rectangle_bg_cyan_50_radius_10, "Name2", "Phone2", "$200", "Area2"),
            CompleteOrder(R.drawable.rectangle_bg_cyan_50_radius_10, "Name3", "Phone3", "$150", "Area3"),
            CompleteOrder(R.drawable.rectangle_bg_cyan_50_radius_10, "Name4", "Phone4", "$180", "Area4"),
            CompleteOrder(R.drawable.rectangle_bg_cyan_50_radius_10, "Name5", "Phone5", "$120", "Area5")
        )
        newRecyclerView = findViewById(R.id.recyclerComplete)
        newRecyclerView.setHasFixedSize(true)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.adapter  = RowCompleteOrderAdapter(newArrayList)

    }


}