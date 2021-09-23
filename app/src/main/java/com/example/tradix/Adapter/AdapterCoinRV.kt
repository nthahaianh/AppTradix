package com.example.tradix.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.Model.Coin
import com.example.tradix.R

class AdapterCoinRV(private var coinList: MutableList<Coin>) :
    RecyclerView.Adapter<AdapterCoinRV.ViewHolder>() {
    lateinit var itemClick: (position: Int) -> Unit

    fun setCallBack(click: (position: Int) -> Unit) {
        itemClick = click
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var coin = coinList[position]
        holder.tvName.text = coin.name + " - " + position
        holder.tvLocation.text = coin.location
        holder.tvTime.text = coin.time
        holder.tvIndex.text = coin.money
        holder.tvPercent.text = coin.percent
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName: TextView
        var tvLocation: TextView
        var tvTime: TextView
        var tvIndex: TextView
        var tvPercent: TextView

        init {
            tvName = view.findViewById(R.id.item_coin_name)
            tvLocation = view.findViewById(R.id.item_voin_location)
            tvTime = view.findViewById(R.id.item_coin_time)
            tvIndex = view.findViewById(R.id.item_coin_index)
            tvPercent = view.findViewById(R.id.item_coin_percent)

            view.setOnClickListener {
                val position: Int = adapterPosition
                itemClick.invoke(position)
            }
        }
    }

    fun remove(viewHolder: RecyclerView.ViewHolder) {
        coinList.removeAt(viewHolder.adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)
    }
}