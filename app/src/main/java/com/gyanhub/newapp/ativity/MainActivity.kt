package com.gyanhub.newapp.ativity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gyanhub.newapp.R
import com.gyanhub.newapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTaskA.setOnClickListener {
            startActivity(Intent(this,Task1Activity::class.java))
        }
        binding.btnTaskB.setOnClickListener {
            startActivity(Intent(this,Task2Activity::class.java))
        }
    }
}