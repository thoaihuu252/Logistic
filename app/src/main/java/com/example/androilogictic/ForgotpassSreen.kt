package com.example.androilogictic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ForgotpassSreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpass_sreen)
        val backLogin = findViewById<Button>(R.id.back)
        backLogin.setOnClickListener{
            val intent = Intent(this, LoginSreen::class.java)
            startActivity(intent)
        }
    }
}