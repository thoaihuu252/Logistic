package com.example.androilogictic.Sreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androilogictic.Adapter.RowWarehouseAdapter
import com.example.androilogictic.Model.CompleteOrder
import com.example.androilogictic.Model.Warehouse
import com.example.androilogictic.R

class WarehouseSreen : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private  lateinit var newArrayList: ArrayList<Warehouse>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warehouse_sreen)
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
            Warehouse( "Nhà kho 1","TP Thủ đức",89) ,
            Warehouse( "Nhà kho 2","TP Thủ đức",89) ,
            Warehouse( "Nhà kho 3","TP Thủ đức",89) ,
            Warehouse( "Nhà kho 4","TP Thủ đức",89) ,
            Warehouse( "Nhà kho 5","TP Thủ đức",89) ,
        )
        newRecyclerView = findViewById(R.id.recyclerWarehouse)
        newRecyclerView.setHasFixedSize(true)
        newRecyclerView.adapter = RowWarehouseAdapter(newArrayList)
    }
}