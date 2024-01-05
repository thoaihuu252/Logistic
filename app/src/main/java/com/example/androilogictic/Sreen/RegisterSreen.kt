package com.example.androilogictic.Sreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androilogictic.R

class RegisterSreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_sreen)

        val backLogin = findViewById<Button>(R.id.backLogin)
        backLogin.setOnClickListener{
            val intent = Intent(this, LoginSreen::class.java)
            startActivity(intent)
        }

    }
}