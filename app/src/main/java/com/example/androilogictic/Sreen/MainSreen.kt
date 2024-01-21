package com.example.androilogictic.Sreen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import android.widget.TextView
import android.widget.Toast
import com.example.androilogictic.Api.ApiProject
import com.example.androilogictic.Api.ApiWeather
import com.example.androilogictic.Model.Product
import com.example.androilogictic.Model.User
import com.example.androilogictic.Model.WeatherResponse
import com.example.androilogictic.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainSreen : AppCompatActivity() {
    private val userArrayList: ArrayList<User> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_sreen)



        fun navigateToScreen(destinationClass: Class<*>) {
            val intent = Intent(this, destinationClass)
            startActivity(intent)
        }

        val bottomNavView: BottomNavigationView = findViewById(R.id.bottomNavView)
        bottomNavView.setSelectedItemId(R.id.menu_home);
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
        getMyData()
        val linearCard : LinearLayout = findViewById(R.id.linearCard)
        linearCard.setOnClickListener{navigateToScreen(OrderSreen::class.java)}





    //API weather
        val apiKey = "9c45e36329e9482e9c5104828240901"
        val location = "Ho Chi Minh city"
        val includeAqi = "yes"

        val call = ApiWeather.RetrofitClient.weatherApiService.getCurrentWeather(apiKey, location, includeAqi)

        call.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    val weatherResponse = response.body()
                    if (weatherResponse != null) {
                        val name = weatherResponse.location.name
                        val tempC = weatherResponse.current.temp_c
                        val combinedText = "$name - $tempC °C"

                        val combinedTextView: TextView = findViewById(R.id.txtWeather)
                        combinedTextView.text = combinedText
                    }
                } else {
                    Toast.makeText(applicationContext, "Mạng không ổn định", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Đã xảy ra lỗi: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
       // day month Year
        val calendar: Calendar = Calendar.getInstance()
        val dayOfWeek: Int = calendar.get(Calendar.DAY_OF_WEEK)
        val dayOfWeekString: String = when (dayOfWeek) {
            Calendar.SUNDAY -> "Chủ nhật"
            Calendar.MONDAY -> "Thứ 2"
            Calendar.TUESDAY -> "Thứ 3"
            Calendar.WEDNESDAY -> "Thứ 4"
            Calendar.THURSDAY -> "Thứ 5"
            Calendar.FRIDAY -> "Thứ 6"
            Calendar.SATURDAY -> "Thứ 7"
            else -> ""
        }
        val dayOfMonth: Int = calendar.get(Calendar.DAY_OF_MONTH)
        val monthString: String = SimpleDateFormat("MMMM", Locale.getDefault()).format(calendar.time)
        val dayText: TextView = findViewById(R.id.txtDuration)
        dayText.text = "$dayOfWeekString , $dayOfMonth $monthString"


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

                        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                        val userId = sharedPreferences.getString("USER_ID", null)
                        val name :TextView =findViewById(R.id.txtJohnSmith)
                        val txtPrice :TextView =findViewById(R.id.txtPrice)
                        val txtMoneyOrder :TextView =findViewById(R.id.txtMoneyOrder)


                        for (u : User in userArrayList ){
                            if (u.id.equals(userId)){
                                name.text = u.name
                                txtPrice.text = u.total.toString()
                                txtMoneyOrder.text = u.email
                            }
                        }
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

}