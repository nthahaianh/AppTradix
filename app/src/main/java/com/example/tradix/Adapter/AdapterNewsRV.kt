package com.example.tradix.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.Model.News
import com.example.tradix.R

class AdapterNewsRV(private var newsList: MutableList<News>) :
    RecyclerView.Adapter<AdapterNewsRV.ViewHolder>() {
    lateinit var itemClick: (position: Int) -> Unit

    fun setCallBack(click: (position: Int) -> Unit) {
        itemClick = click
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var news = newsList[position]
        holder.img.setImageResource(news.img)
        holder.tvPercent.text = news.percent
        holder.tvDate.text = news.date
        holder.tvTitle.text = news.title
        holder.tvContent.text = news.content
        holder.itemView.setOnClickListener {
            itemClick.invoke(position) }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var img: ImageView
        var tvPercent: TextView
        var tvDate: TextView
        var tvTitle: TextView
        var tvContent: TextView

        init {
            img = view.findViewById(R.id.item_news_iv)
            tvPercent = view.findViewById(R.id.item_news_percent)
            tvDate = view.findViewById(R.id.item_news_date)
            tvTitle = view.findViewById(R.id.item_news_title)
            tvContent = view.findViewById(R.id.item_news_content)

            view.setOnClickListener {
                val position: Int = adapterPosition

            }
        }
    }
}