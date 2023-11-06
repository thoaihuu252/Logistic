package com.example.androilogictic

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText

class LoginSreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_sreen)

        val username = findViewById<TextInputEditText>(R.id.usernameLogin)
        val pass = findViewById<TextInputEditText>(R.id.passwordLogin)

        val register = findViewById<Button>(R.id.registerButton)
        val forgotPass = findViewById<Button>(R.id.forgotPassButton)
        val login = findViewById<Button>(R.id.Login)
//
//        //Listerner
        register.setOnClickListener {
            val intent = Intent(this, RegisterSreen::class.java)
            startActivity(intent)
        }
        forgotPass.setOnClickListener {
            val intent = Intent(this, ForgotpassSreen::class.java)
            startActivity(intent)
        }

        login.setOnClickListener {
            val intent = Intent (this, MainSreen::class.java)
            val dialog = AlertDialog.Builder(this)
            dialog.apply {
                setTitle("Ngooo")
                setMessage("Cook mọe mày di.....")
                setNegativeButton("Hmm"){ dialogInterface: DialogInterface, i: Int -> dialogInterface.dismiss()}
                setPositiveButton("Yahh sure"){ dialogInterface: DialogInterface, i: Int -> dialogInterface.dismiss()}
            }

            if (username.text.toString().equals("thoai") && pass.text.toString().equals("123")) {
                startActivity(intent)
            } else {
                dialog.show()
            }

        }
        //finish

    }
}