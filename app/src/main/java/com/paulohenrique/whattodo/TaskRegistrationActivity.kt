package com.paulohenrique.whattodo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.paulohenrique.whattodo.databinding.ActivityTaskRegistrationBinding
import com.vicmikhailau.maskededittext.MaskedFormatter
import com.vicmikhailau.maskededittext.MaskedWatcher

class TaskRegistrationActivity : AppCompatActivity() {

    lateinit var binding: ActivityTaskRegistrationBinding
    val formatterDate = MaskedFormatter("##/##/####")
    val formatterHour = MaskedFormatter("##:## hs")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskRegistrationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        globalTask.clear()
        binding.txtDateTask.addTextChangedListener(MaskedWatcher(formatterDate, binding.txtDateTask))
        binding.txtHourTask.addTextChangedListener(MaskedWatcher(formatterHour, binding.txtHourTask))

        binding.btnInsertTask.setOnClickListener {
            val task = binding.txtTask.text.toString()
            val date = binding.txtDateTask.text.toString()
            val hour = binding.txtHourTask.text.toString()

            if (task.isNotEmpty()) {
                val itemTask = Task(task, date, hour)
                globalTask.add(itemTask)
                binding.txtTask.text.clear()
                binding.txtDateTask.text.clear()
                binding.txtHourTask.text.clear()

                val taskAdapter = TaskAdapter(this)
                taskAdapter.addAll(globalTask)
                binding.listViewTasks.adapter = taskAdapter
            } else {
                binding.txtTask.error = "Preencha o nome da tarefa!"
            }
        }
    }
}