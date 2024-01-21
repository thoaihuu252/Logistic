package com.example.androilogictic.Sreen

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androilogictic.Adapter.RowProductAdapter
import com.example.androilogictic.Api.ApiProject
import com.example.androilogictic.Model.Order
import com.example.androilogictic.Model.Product
import com.example.androilogictic.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

open class BottomSheet: BottomSheetDialogFragment() {
    companion object {
        fun newInstance(productList: ArrayList<Product>, order: Order ): BottomSheet {
            val bottomSheet = BottomSheet()
            bottomSheet.productList = productList
            bottomSheet.order = order
            return bottomSheet
        }
    }
    private lateinit var productList: ArrayList<Product>
    private lateinit var order: Order
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewProduct)
        val textID = view.findViewById<TextView>(R.id.textOrderId)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RowProductAdapter(productList)
        textID.text = order.id

        val btnClose = view.findViewById<Button>(R.id.btnCloseSheet)

        val btnComplete = view.findViewById<Button>(R.id.       btnCompleteSheet)


        btnClose.setOnClickListener {
            dismiss()
        }
        btnComplete.setOnClickListener{
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Xác nhận hoàn thành đơn  hàng")
                .setMessage("Bạn chắc chắn muốn hoàn thành đơn đặt hàng này?")
                .setPositiveButton("Đồng ý") { dialog, which ->
                    // Xử lý khi người dùng bấm nút "Đồng ý"
                    val call = ApiProject.RetrofitClient.apiBuilder.updateOrderStatus(order.id, "Complete")
                    call.enqueue(object : Callback<Order> {
                        override fun onResponse(call: Call<Order>, response: Response<Order>) {
                            if (response.isSuccessful) {
                                // Xử lý khi request thành công
                                val updatedOrder = response.body()
                                // Do something with updatedOrder
                            } else {

                            }
                        }

                        override fun onFailure(call: Call<Order>, t: Throwable) {


                        }
                    })
                    dismiss()
                }
                .setNegativeButton("Hủy bỏ") { dialog, which ->
                    // Xử lý khi người dùng bấm nút "Hủy bỏ"
                    dialog.dismiss()
                }
                .show()

        }

    }





}



