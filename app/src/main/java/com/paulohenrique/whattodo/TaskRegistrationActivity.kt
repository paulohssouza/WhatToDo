package com.paulohenrique.whattodo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.paulohenrique.whattodo.databinding.ActivityTaskRegistrationBinding

class TaskRegistrationActivity : AppCompatActivity() {

    lateinit var binding: ActivityTaskRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskRegistrationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}