package com.example.androilogictic.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.androilogictic.Model.Order
import com.example.androilogictic.R

class RowCompleteOrderAdapter(private val newList : ArrayList<Order> ) :
    RecyclerView.Adapter<RowCompleteOrderAdapter.CompleteViewHolder>() {
    var onClick : ((Order)-> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompleteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_complete,parent,false)
        return RowCompleteOrderAdapter.CompleteViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: CompleteViewHolder, position: Int) {
        val currentItem = newList[position]
        holder.phone.text = currentItem.phoneOrder
        holder.price.text = currentItem.priceOrder.toString()
        holder.nameKhach.text = currentItem.nameOrder
        holder.area.text = currentItem.areaOrder
        holder.itemView.setOnClickListener{
            onClick?.invoke(currentItem)
        }
    }
    class CompleteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameKhach : TextView = itemView.findViewById(R.id.txtNameComplete)
        val phone : TextView = itemView.findViewById(R.id.txtPhoneNumberComplete)
        val price : TextView = itemView.findViewById(R.id.txtPriceComplete)
        val area : AppCompatButton = itemView.findViewById(R.id.btnArea)

    }

}