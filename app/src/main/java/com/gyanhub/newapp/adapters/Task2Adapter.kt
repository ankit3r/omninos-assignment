package com.gyanhub.newapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gyanhub.newapp.R

class Task2Adapter(
    private val context: Context, private val list: ArrayList<String>,
    val click: Task2,
    val id: CheckBox
) : RecyclerView.Adapter<Task2Adapter.Task2ViewHolder>() {
    var check = false

    inner class Task2ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txt2: TextView = view.findViewById(R.id.txtTask2)
        val btn: CheckBox = view.findViewById(R.id.btnCheck)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Task2ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task2card, parent, false)
        return Task2ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Task2ViewHolder, position: Int) {
        holder.txt2.text = list[position]
        holder.btn.isChecked = check
        holder.btn.setOnClickListener {
            if (holder.btn.isChecked) {
                click.checkBtn(position)
            } else {
                click.unChecked(list[position])
            }
        }
        id.setOnClickListener {
            if (check) {
                check = false
                click.clearSelect()
                notifyDataSetChanged()
            } else {
                check = true
                click.selectAll(list)
                notifyDataSetChanged()
            }
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }
}

interface Task2 {
    fun checkBtn(position: Int)
    fun selectAll(list: ArrayList<String>)
    fun unChecked(data: String)
    fun clearSelect()
}