package com.paulohenrique.whattodo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.paulohenrique.whattodo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val rotateOpen: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.rotate_open_anime)
    }
    private val rotateClose: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.rotate_close_anime)
    }
    private val fromBottom: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.from_bottom_anime)
    }
    private val toBottom: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.to_bottom_anime)
    }
    private var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val itemAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        binding.listViewItens.adapter = itemAdapter

        binding.btnAdd.setOnClickListener {
            onAddButtonClicked()
        }

        binding.btnAddListTask.setOnClickListener {
            onAddButtonClicked()
            val intent = Intent(this, TaskRegistrationActivity::class.java)
            startActivity(intent)
        }

        binding.btnAddListProduct.setOnClickListener {
            onAddButtonClicked()
            val intent = Intent(this, ProductResgistrationActivity::class.java)
            startActivity(intent)
        }

    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            binding.btnAddListTask.visibility = View.VISIBLE
            binding.btnAddListProduct.visibility = View.VISIBLE
        } else {
            binding.btnAddListTask.visibility = View.INVISIBLE
            binding.btnAddListProduct.visibility = View.INVISIBLE
        }
    }
    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            binding.btnAddListTask.startAnimation(fromBottom)
            binding.btnAddListProduct.startAnimation(fromBottom)
            binding.btnAdd.startAnimation(rotateOpen)
        } else {
            binding.btnAddListTask.startAnimation(toBottom)
            binding.btnAddListProduct.startAnimation(toBottom)
            binding.btnAdd.startAnimation(rotateClose)
        }
    }

}