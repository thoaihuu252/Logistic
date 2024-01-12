package com.example.androilogictic.Sreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androilogictic.Adapter.RowOrderAdapter
import com.example.androilogictic.Model.Order
import com.example.androilogictic.Model.Warehouse
import com.example.androilogictic.R

class OrderDetailSreen : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail_sreen)
        val warehouse = intent.getParcelableExtra<Warehouse>("warehouse")
        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        if (warehouse != null){
            var txtWarehouse : TextView = findViewById(R.id.textWhDetail)
            txtWarehouse.text = warehouse.nameWarehouse
        }

        btnBack.setOnClickListener {
            onBackPressed()
        }

        val newArrayList = arrayListOf(
            Order( "1","Name1", "Phone1", 100, "Area1","Chờ",10),
            Order("2","Name2", "Phone2", 200, "Area2","Chờ",10),
            Order( "3","Name3", "Phone3", 150, "Area3","Chờ",10),
            Order( "4","Name3", "Phone3", 150, "Area3","Chờ",10)
        )

        newRecyclerView = findViewById(R.id.rcv_order_wh)
        newRecyclerView.setHasFixedSize(true)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        val orderAdt = RowOrderAdapter(newArrayList)
        newRecyclerView.adapter  = orderAdt
    }
}


