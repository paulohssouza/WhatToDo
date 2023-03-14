package com.paulohenrique.whattodo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class TaskAdapter (context: Context) : ArrayAdapter<Task>(context, 0) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView
            ?: LayoutInflater.from(context)
                .inflate(R.layout.list_view_task, parent, false)
        val item = getItem(position)
        val txt_name_task = view.findViewById<TextView>(R.id.txt_item_task)
        val txt_date_task = view.findViewById<TextView>(R.id.txt_item_date_task)
        val txt_hour_task = view.findViewById<TextView>(R.id.txt_item_time_task)

        if (item != null) {
            txt_name_task.text = item.name
            txt_date_task.text = item.date
            txt_hour_task.text = item.time
        }
        return view
    }
}