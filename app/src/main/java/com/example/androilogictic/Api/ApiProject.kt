package com.example.androilogictic.Api

import com.example.androilogictic.Model.Order
import com.example.androilogictic.Model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiProject {

    //APi :http://localhost:8080/
    @GET("api/users")
    fun getUsers(): Call<ArrayList<User>>

    @GET("api/orders")
    fun getOrder(): Call<ArrayList<Order>>


    object RetrofitClient {
        private const val BASE_URL =  "http://192.168.1.129:8080/"

        val apiBuilder: ApiProject by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(ApiProject::class.java)
        }
    }
}