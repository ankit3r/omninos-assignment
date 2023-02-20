package com.gyanhub.newapp.ativity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.gyanhub.newapp.adapters.Task2
import com.gyanhub.newapp.adapters.Task2Adapter
import com.gyanhub.newapp.databinding.ActivityTask2Binding

class Task2Activity : AppCompatActivity(),Task2 {
    private lateinit var list:ArrayList<String>
    private lateinit var binding: ActivityTask2Binding
    private lateinit var task2Adapter: Task2Adapter
    private lateinit var sendList:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTask2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Task B"

        list = ArrayList<String>()
        sendList = ArrayList<String>()
        for (i in 0..6) {
            list.add("Index${i}")
        }

        binding.reViewTask2.layoutManager = LinearLayoutManager(this)
        task2Adapter = Task2Adapter(this,list,this,binding.btnCheck1)
        binding.reViewTask2.adapter = task2Adapter

        binding.btnSend.setOnClickListener {
          if (sendList.isEmpty()){
              Toast.makeText(this, "Select Data", Toast.LENGTH_SHORT).show()
          }else{
              val intent = Intent(this,Task2Result::class.java)
              intent.putStringArrayListExtra("data",sendList)
              startActivity(intent)
          }
        }

    }

    override fun checkBtn(position: Int) {
        sendList.add(list[position])
    }

    override fun selectAll(list: ArrayList<String>) {
        sendList.clear()
        sendList.addAll(list)
    }

    override fun unChecked(data: String) {
        sendList.remove(data)
    }

    override fun clearSelect() {
        sendList.clear()
    }
}