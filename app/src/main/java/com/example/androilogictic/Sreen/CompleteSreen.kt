package com.example.androilogictic.Sreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androilogictic.Adapter.RowCompleteOrderAdapter
import com.example.androilogictic.Model.CompleteOrder
import com.example.androilogictic.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class CompleteSreen : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private  lateinit var completeList: ArrayList<CompleteOrder>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_sreen)


        val btnSearch: ImageView = findViewById(R.id.btnSearch)

        fun navigateToScreen(destinationClass: Class<*>) {
            val intent = Intent(this, destinationClass)
            startActivity(intent)
        }
        btnSearch.setOnClickListener { navigateToScreen(SearchSreen::class.java) }

        val bottomNavView: BottomNavigationView = findViewById(R.id.bottomNavView)
        bottomNavView.setSelectedItemId(R.id.menu_complete);
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


        completeList = arrayListOf(
            CompleteOrder("1",R.drawable.img_vector, "Name1", "Phone1", "$100", "Area1"),
            CompleteOrder("2",R.drawable.img_vector, "Name2", "Phone2", "$200", "Area2"),
            CompleteOrder("3",R.drawable.img_vector, "Name3", "Phone3", "$150", "Area3"),
            CompleteOrder("4",R.drawable.img_vector, "Name4", "Phone4", "$180", "Area4"),
            CompleteOrder("5",R.drawable.img_vector, "Name5", "Phone5", "$120", "Area5")
        )
        newRecyclerView = findViewById(R.id.recyclerComplete)
        newRecyclerView.setHasFixedSize(true)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.adapter  = RowCompleteOrderAdapter(completeList)

    }


}