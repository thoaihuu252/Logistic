package com.example.androilogictic.Sreen

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.androilogictic.Api.ApiProject
import com.example.androilogictic.Api.ApiWeather
import com.example.androilogictic.Model.CompleteOrder
import com.example.androilogictic.Model.User
import com.example.androilogictic.Model.WeatherResponse
import com.example.androilogictic.R
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginSreen : AppCompatActivity() {
    private  lateinit var userArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_sreen)

        val username = findViewById<TextInputEditText>(R.id.usernameLogin)
        val pass = findViewById<TextInputEditText>(R.id.passwordLogin)

        val register = findViewById<Button>(R.id.registerButton)
        val login = findViewById<Button>(R.id.Login)
//
        //APi
        val callUser = ApiProject.RetrofitClient.apiUser.getUsers()
        callUser .enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val users = response.body()
                    if (users != null) {
                        userArrayList.addAll(users)
                    }
                } else {
                    Toast.makeText(applicationContext, "Có lỗi khi lấy dữ liệu từ API", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(applicationContext, "Đã xảy ra lỗi: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

        //
//        //Listerner
        register.setOnClickListener {
            val intent = Intent(this, RegisterSreen::class.java)
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
            //for (u in userArrayList) {
                val uName ="thoai" //u.nameUser
                val uPass = "123"//u.pass
                if (username.text.toString().equals(uName)
                    && pass.text.toString().equals(uPass)
                ) {
                    startActivity(intent)
                } else {
                    dialog.show()
                }
            //}
        }
        // day month Year

    }
}