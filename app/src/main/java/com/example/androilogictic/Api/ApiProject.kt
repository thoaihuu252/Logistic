package com.example.androilogictic.Api

import com.example.androilogictic.Model.Order
import com.example.androilogictic.Model.User
import com.example.androilogictic.Model.Warehouse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiProject {

    //APi :http://localhost:8080/
    @GET("user")
    fun getUsers(): Call<ArrayList<User>>

    @GET("orders")
    fun getOrder(): Call<ArrayList<Order>>
    @GET("api/warehouses")
    fun getWarehouse(): Call<ArrayList<Warehouse>>

    @GET("/api/orders/searchByName")
    fun searchOrdersByName(@Query("name") name: String?): Call<ArrayList<Order?>?>?

    @PUT("/update-status-order/{id}")
    fun updateOrderStatus(
        @Path("id") id: String,
        @Query("newStatus") newStatus: String
    ): Call<Order>


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