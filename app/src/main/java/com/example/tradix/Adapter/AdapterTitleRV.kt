package com.example.tradix.Adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.R

class AdapterTitleRV(private val titleList: MutableList<String>, private val type: String) :
    RecyclerView.Adapter<AdapterTitleRV.ViewHolder>() {
    lateinit var itemClick: (position: Int) -> Unit

    fun setCallBack(click: (position: Int) -> Unit) {
        itemClick = click
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_title, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var string = titleList[position]
        holder.tv.text = string
        holder.tv.setOnClickListener {
            if (type == "type1") {
                holder.tv.setTextColor(Color.WHITE)
                holder.tv.setBackgroundResource(R.drawable.background4)
            } else {
                holder.tv.setBackgroundResource(R.drawable.background3)
            }
        }
    }

    override fun getItemCount(): Int {
        return titleList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tv: TextView

        init {
            tv = view.findViewById(R.id.item_title_tv)
        }
    }
}