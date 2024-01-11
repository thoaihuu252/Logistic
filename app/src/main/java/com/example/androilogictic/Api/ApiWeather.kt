package com.example.androilogictic.Api

import com.example.androilogictic.Model.WeatherResponse
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiWeather {
    //APi : https://api.weatherapi.com/v1/current.json?key=9c45e36329e9482e9c5104828240901&q=Ho Chi Minh city&aqi=yes
    @GET("v1/current.json")
    fun getCurrentWeather(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("aqi") includeAqi: String
    ): Call<WeatherResponse>
    object RetrofitClient {
        private const val BASE_URL = "https://api.weatherapi.com/"

        val weatherApiService: ApiWeather by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(ApiWeather::class.java)
        }
    }
}