package com.example.androilogictic.Sreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.androilogictic.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileSreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_sreen)

        val logout: LinearLayout = findViewById(R.id.btnLogout)

        fun navigateToScreen(destinationClass: Class<*>) {
            val intent = Intent(this, destinationClass)
            startActivity(intent)
        }
        val bottomNavView: BottomNavigationView = findViewById(R.id.bottomNavView)
        bottomNavView.setSelectedItemId(R.id.menu_profile);
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

        logout.setOnClickListener { navigateToScreen(LoginSreen::class.java) }

    }
}