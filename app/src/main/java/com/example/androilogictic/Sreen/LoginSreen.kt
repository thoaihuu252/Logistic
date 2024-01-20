package com.example.androilogictic.Sreen

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.androilogictic.Api.ApiProject
import com.example.androilogictic.Model.User
import com.example.androilogictic.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginSreen : AppCompatActivity() {
    private val userArrayList: ArrayList<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_sreen)

        val username = findViewById<TextInputEditText>(R.id.usernameLogin)
        val pass = findViewById<TextInputEditText>(R.id.passwordLogin)
        val register = findViewById<Button>(R.id.registerButton)
        val login = findViewById<Button>(R.id.Login)
        //APi
        getMyData()

        //Listerner
        register.setOnClickListener {
            val intent = Intent(this, RegisterSreen::class.java)
            startActivity(intent)
        }


        login.setOnClickListener {
            val intent = Intent (this, MainSreen::class.java)
            for (u in userArrayList) {
                val uName =u.name
                val uPass = u.password
                if (username.text.toString().equals(uName)
                    && pass.text.toString().equals(uPass)
                ) {
                    startActivity(intent)
                    break
                } else {
                    showLoginFailedDialog()
                }
            }
        }
    }
    // funtion getAPi bằng retrofit
    private fun getMyData(){
        val retroData = ApiProject.RetrofitClient.apiBuilder.getUsers()
        retroData.enqueue(object : Callback<ArrayList<User>> {
            override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {
                if (response.isSuccessful) {
                    val users = response.body()
                    if (users != null) {
                        userArrayList.addAll(users)
                    }
                } else {
                    Toast.makeText(applicationContext, "Có lỗi khi lấy dữ liệu từ API", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                Toast.makeText(applicationContext, "Đã xảy ra lỗi: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

    }
    // thông báo đăng nhập sai
    private fun showLoginFailedDialog() {
        val context = this
        val alertDialog = MaterialAlertDialogBuilder(context)
            .setTitle("Đăng nhập thất bại")
            .setMessage("Tên người dùng hoặc mật khẩu không đúng. Vui lòng thử lại.")
            .setPositiveButton("OK") { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            .setBackgroundInsetStart(16)
            .setBackgroundInsetEnd(16)
            .create()

        alertDialog.show()
    }

}