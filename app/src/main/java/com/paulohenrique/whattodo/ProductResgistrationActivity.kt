package com.paulohenrique.whattodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paulohenrique.whattodo.databinding.ActivityProductResgistrationBinding
import com.paulohenrique.whattodo.databinding.ActivityTaskRegistrationBinding

class ProductResgistrationActivity : AppCompatActivity() {

    lateinit var binding: ActivityProductResgistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductResgistrationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}