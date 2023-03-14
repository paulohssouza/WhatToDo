package com.paulohenrique.whattodo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import com.paulohenrique.whattodo.data.Product
import com.paulohenrique.whattodo.R

class ProductAdapter (context: Context) : ArrayAdapter<Product> (context, 0) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView
            ?: LayoutInflater.from(context)
                .inflate(R.layout.list_view_product, parent, false)
        val item = getItem(position)
        val txt_name_product = view.findViewById<TextView>(R.id.txt_item_product)
        val txt_quantity_product = view.findViewById<TextView>(R.id.txt_item_quantity_product)
        val txt_unity_product = view.findViewById<TextView>(R.id.txt_item_unity_product)

        if (item != null) {
            txt_name_product.text = item.name
            txt_quantity_product.text = item.quantity.toString()
            txt_unity_product.text = item.unity
        }
        return view
    }
}