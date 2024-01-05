package com.example.androilogictic.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.androilogictic.Model.CompleteOrder
import com.example.androilogictic.R

class RowCompleteOrderAdapter(private val newList : ArrayList<CompleteOrder> ) :
    RecyclerView.Adapter<RowCompleteOrderAdapter.CompleteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompleteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_complete,parent,false)
        return CompleteViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: CompleteViewHolder, position: Int) {
        val currentItem = newList[position]
        holder.img.setImageResource(currentItem.img)
        holder.phone.text = currentItem.phone
        holder.price.text = currentItem.price
        holder.nameKhach.text = currentItem.name
        holder.area.text = currentItem.area
    }
    class CompleteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val img : ImageButton = itemView.findViewById(R.id.imgComplete)
        val nameKhach : TextView = itemView.findViewById(R.id.txtNameComplete)
        val phone : TextView = itemView.findViewById(R.id.txtPhoneNumberComplete)
        val price : TextView = itemView.findViewById(R.id.txtPriceComplete)
        val area : AppCompatButton = itemView.findViewById(R.id.btnArea)

    }

}