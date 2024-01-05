package com.example.androilogictic.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.androilogictic.Model.CompleteOrder
import com.example.androilogictic.Model.Order
import com.example.androilogictic.R

class RowOrderAdapter(private val newList : ArrayList<Order> ) :  RecyclerView.Adapter<RowOrderAdapter.OrderViewHolder>(){

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameKhach : TextView = itemView.findViewById(R.id.txtNameOrder)
        val phone : TextView = itemView.findViewById(R.id.txtPhoneNumberOrder)
        val price : TextView = itemView.findViewById(R.id.txtPriceOrder)
        val area : AppCompatButton = itemView.findViewById(R.id.btnAreaOrder)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_order,parent,false)
        return RowOrderAdapter.OrderViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val currentItem = newList[position]
        holder.phone.text = currentItem.phoneOrder
        holder.price.text = currentItem.priceOrder
        holder.nameKhach.text = currentItem.nameOrder
        holder.area.text = currentItem.areaOrder
    }
}