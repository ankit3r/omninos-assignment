package com.gyanhub.newapp.ativity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.gyanhub.newapp.adapters.ResultAdapter
import com.gyanhub.newapp.databinding.ActivityTask2ResultBinding

class Task2Result : AppCompatActivity() {
    private lateinit var binding: ActivityTask2ResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTask2ResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Task B Result"
        binding.rcViewResult.layoutManager = LinearLayoutManager(this)
        val myAdapter = ResultAdapter(intent.getStringArrayListExtra("data")!!)
        binding.rcViewResult.adapter = myAdapter
    }
}