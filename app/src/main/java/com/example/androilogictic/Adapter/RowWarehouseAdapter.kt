package com.example.androilogictic.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.androilogictic.Model.Warehouse
import com.example.androilogictic.R


class RowWarehouseAdapter(private val newList : ArrayList<Warehouse>) : RecyclerView.Adapter<RowWarehouseAdapter.WarehouseHolder>(){

    var onClick : ((Warehouse)-> Unit)? = null
    class WarehouseHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
//        Wh = warehouse
        val nameWh : TextView = itemView.findViewById(R.id.txtNameWarehouse)
        val areaWh : TextView = itemView.findViewById(R.id.txtAreaWarehouse)
        val orderNumberWh : TextView = itemView.findViewById(R.id.txtOrderNumberWarehouse)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WarehouseHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_warehouse,parent,false)
        return WarehouseHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: WarehouseHolder, position: Int) {
        val currentItem = newList[position]
        val number = "Số đơn trong kho : " + currentItem.numberOrderWh
        holder.nameWh.text = currentItem.nameWh
        holder.areaWh.text = currentItem.areaWh
        holder.orderNumberWh.text = number
        holder.itemView.setOnClickListener{
            onClick?.invoke(currentItem)
        }


    }
}