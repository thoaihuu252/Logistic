package com.example.androilogictic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class WarehouseSreen : AppCompatActivity() {
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
    }
}