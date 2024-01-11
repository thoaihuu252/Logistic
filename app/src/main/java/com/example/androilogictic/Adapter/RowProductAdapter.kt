package com.example.androilogictic.Adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androilogictic.Model.Product
import com.example.androilogictic.R

class RowProductAdapter (private val newList : ArrayList<Product>) : RecyclerView.Adapter<RowProductAdapter.ProductHolder>() {
    class ProductHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        //        Wh = warehouse
        val namePro : TextView = itemView.findViewById(R.id.txtNameProduct)
        val nameShop : TextView = itemView.findViewById(R.id.txtNameShop)
        val pricePro : TextView = itemView.findViewById(R.id.txtPriceProduct)
        val layout : LinearLayout = itemView.findViewById(R.id.layoutRowProduct)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_product,parent,false)
        return RowProductAdapter.ProductHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val currentItem = newList[position]
        holder.namePro.text = currentItem.nameProduct
        holder.nameShop.text = currentItem.nameShop
        holder.pricePro.text = currentItem.priceProduct

    }
}