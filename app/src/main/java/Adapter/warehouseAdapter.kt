package Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bean.warehouse
import com.example.androilogictic.R
import com.google.android.material.imageview.ShapeableImageView

class warehouseAdapter(private val warehouseList: ArrayList<warehouse>) :
    RecyclerView.Adapter<warehouseAdapter.MainUserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainUserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_main_user, parent, false)
        return MainUserViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return warehouseList.size
    }

    override fun onBindViewHolder(holder: MainUserViewHolder, position: Int) {
        val currentItem = warehouseList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.titleName.text = currentItem.titlename
        holder.titleArea.text = currentItem.area
        holder.titleTotal.text = currentItem.totalOrder
    }

    class MainUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleImage: ShapeableImageView = itemView.findViewById(R.id.imageItem)
        val titleName: TextView = itemView.findViewById(R.id.textItem)
        val titleArea: TextView = itemView.findViewById(R.id.textItem2)
        val titleTotal: TextView = itemView.findViewById(R.id.textItem4)
    }
}