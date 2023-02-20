package com.gyanhub.newapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gyanhub.newapp.R
import java.util.ArrayList

class ResultAdapter(
    private var list: ArrayList<String>
):RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {
    inner class ResultViewHolder(view:View):RecyclerView.ViewHolder(view){
        val txt : TextView = view.findViewById(R.id.txtResult)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.resultcard, parent, false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.txt.text = list[position]
    }

    override fun getItemCount(): Int {
      return list.size
    }
}