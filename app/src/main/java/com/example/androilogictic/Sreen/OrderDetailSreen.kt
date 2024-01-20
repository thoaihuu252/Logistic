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
    private var orderList: ArrayList<Order> = ArrayList()
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


        newRecyclerView = findViewById(R.id.rcv_order_wh)
        newRecyclerView.setHasFixedSize(true)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        val orderAdt = RowOrderAdapter(orderList)
        newRecyclerView.adapter  = orderAdt
    }
}


