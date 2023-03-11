package com.paulohenrique.whattodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.paulohenrique.whattodo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val itemAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        binding.listViewItens.adapter = itemAdapter

        binding.btnInsert.setOnClickListener {
            val item = binding.txtItemList.text.toString()
            if (item.isNotEmpty()) {
                itemAdapter.add(item)
                binding.txtItemList.text.clear()
            } else {
                binding.txtItemList.error = "Preencha o campo de item da lista!"
            }
        }

        binding.listViewItens.setOnItemLongClickListener {
            adapterView: AdapterView<*>, view: View, position: Int, id: Long ->

            val item = itemAdapter.getItem(position)
            itemAdapter.remove(item)

            true
        }
    }
}