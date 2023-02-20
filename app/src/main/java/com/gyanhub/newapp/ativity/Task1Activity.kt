package com.gyanhub.newapp.ativity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.gyanhub.newapp.adapters.Task1
import com.gyanhub.newapp.adapters.Task1Adapter
import com.gyanhub.newapp.databinding.ActivityTask1Binding

@SuppressLint("NotifyDataSetChanged")
class Task1Activity : AppCompatActivity(), Task1 {
    private lateinit var list:ArrayList<String>
    private lateinit var binding: ActivityTask1Binding
    private lateinit var task1Adapter:Task1Adapter
    var positions = 0
    private  var updateText =""
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTask1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Task A"
        list = ArrayList()
        for (i in 0..6) {
            list.add("Index${i}")
        }

        binding.rcViewTask1.layoutManager = LinearLayoutManager(this)
        task1Adapter = Task1Adapter(this,list,this)
        binding.button.text = "ADD"
        binding.rcViewTask1.adapter = task1Adapter

        binding.button.setOnClickListener {
            if(binding.button.text=="ADD"){
                if (list.contains(binding.eTxt.text.toString())){
                    Toast.makeText(this, "Data Already Available", Toast.LENGTH_SHORT).show()
                }else{
                    list.add(binding.eTxt.text.toString())
                    task1Adapter.notifyDataSetChanged()
                    binding.eTxt.setText("")
                }
            }else{
                if (list.contains(binding.eTxt.text.toString())){
                    Toast.makeText(this, "Data Already Available", Toast.LENGTH_SHORT).show()
                }else{
                updateText = binding.eTxt.text.toString()
                list[positions] =  updateText
                task1Adapter.notifyDataSetChanged()
                binding.button.text = "ADD"
                binding.eTxt.setText("")
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun updateData(position: Int) {
        binding.eTxt.setText("")
        binding.eTxt.setText(list[position])
        binding.button.text="UPDATE"
        positions = position

    }
    override fun DeleteData(position: Int) {
        list.removeAt(position)
        task1Adapter.notifyDataSetChanged()

    }
}


