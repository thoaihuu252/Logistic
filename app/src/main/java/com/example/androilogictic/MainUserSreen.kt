package com.example.androilogictic

import Adapter.warehouseAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bean.warehouse

class MainUserSreen : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<warehouse>
    lateinit var imageid: Array<Int>
    lateinit var titlName: Array<String>
    lateinit var titleArea: Array<String>
    lateinit var titleTotal: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_user_sreen)

        imageid = arrayOf(R.drawable.btc, R.drawable.btc, R.drawable.btc, R.drawable.btc)
        titlName = arrayOf("Name1", "Name2", "Name2", "Name2")
        titleArea = arrayOf("titleArea", "titleArea2", "Name2", "Name2")
        titleTotal = arrayOf("titleTotal", "titleTotal2", "Name2", "Name2")

        //
        newRecyclerView = findViewById(R.id.recyleMainuser)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getWareHousedata()

    }
        private fun getWareHousedata() {
            for (i in titlName.indices) {
                val item = warehouse(imageid[i], titlName[i], titleArea[i], titleTotal[i])
                newArrayList.add(item)
            }
            newRecyclerView.adapter = warehouseAdapter(newArrayList)
        }

}