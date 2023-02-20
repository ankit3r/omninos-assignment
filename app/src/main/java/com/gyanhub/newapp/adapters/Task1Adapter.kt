package com.gyanhub.newapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gyanhub.newapp.R

class Task1Adapter(private val context: Context,private val list:ArrayList<String>,val click:Task1)
    :RecyclerView.Adapter<Task1Adapter.Task1ViewHolder>() {
    inner class Task1ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val txt:TextView = view.findViewById(R.id.txtTask1)
        val btn:Button = view.findViewById(R.id.btnDelete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Task1ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task1card, parent, false)
        return Task1ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Task1ViewHolder, position: Int) {
       holder.txt.text = list[position]
        holder.btn.setOnClickListener {
            click.DeleteData(position)
        }
        holder.itemView.setOnClickListener {
            click.updateData(position)
        }
    }

    override fun getItemCount(): Int {
      return list.size
    }
}
interface Task1{
    fun updateData(position:Int)
    fun DeleteData(position:Int)
}
