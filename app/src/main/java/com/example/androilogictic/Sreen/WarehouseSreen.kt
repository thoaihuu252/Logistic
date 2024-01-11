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
import com.google.android.material.bottomnavigation.BottomNavigationView

class WarehouseSreen : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private  lateinit var newArrayList: ArrayList<Warehouse>
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

        newArrayList = arrayListOf(
            Warehouse( "1","Nhà kho 1","TP Thủ đức",89) ,
            Warehouse( "2","Nhà kho 2","TP Thủ đức",89) ,
            Warehouse( "3","Nhà kho 3","TP Thủ đức",89) ,
            Warehouse( "4","Nhà kho 4","TP Thủ đức",89) ,
            Warehouse( "5","Nhà kho 5","TP Thủ đức",89) ,
        )
        newRecyclerView = findViewById(R.id.recyclerWarehouse)
        newRecyclerView.setHasFixedSize(true)
        val WarehouseAdapter = RowWarehouseAdapter(newArrayList)
        newRecyclerView.adapter = WarehouseAdapter
        WarehouseAdapter.onClick = {
            val intent = Intent(this, OrderDetailSreen::class.java)
            intent.putExtra("warehouse",it)
            startActivity(intent)
        }
    }
}