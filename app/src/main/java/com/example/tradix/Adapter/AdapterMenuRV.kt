package com.example.tradix.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.Model.ItemMenu
import com.example.tradix.R

class AdapterMenuRV(private var itemList: MutableList<ItemMenu>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val TYPE1 = 1
    val TYPE2 = 2
    val TYPE3 = 3

    lateinit var itemClick: (position: Int) -> Unit

    fun setCallBack(click: (position: Int) -> Unit) {
        itemClick = click
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE1 -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_menu1,
                    parent,
                    false
                )
                return Item1ViewHolder(view)
            }
            TYPE2 -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_menu2,
                    parent,
                    false
                )
                return Item2ViewHolder(view)
            }
            TYPE3 -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_menu3,
                    parent,
                    false
                )
                return Item3ViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(
                    R.layout.item_menu1,
                    parent,
                    false
                )
                return Item1ViewHolder(view)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].type
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var itemMenu = itemList[position]
        when (itemMenu.type) {
            TYPE1 -> {
                (holder as Item1ViewHolder).setData(itemList[position])
            }
            TYPE2 -> {
                (holder as Item2ViewHolder).setData(itemList[position])
            }
            TYPE3 -> {
                (holder as Item3ViewHolder).setData(itemList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class Item1ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var img: ImageView
        var tvTitle: TextView

        init {
            img = view.findViewById(R.id.item_menu1_iv)
            tvTitle = view.findViewById(R.id.item_menu1_tvTitle)
        }

        fun setData(item: ItemMenu) {
            img.setImageResource(item.img)
            tvTitle.setText(item.title)
        }
    }

    class Item2ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvTitle: TextView

        init {
            tvTitle = view.findViewById(R.id.item_menu2_tvTitle)
        }

        fun setData(item: ItemMenu) {
            tvTitle.setText(item.title)

        }
    }

    class Item3ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var img: ImageView
        var tvTitle: TextView

        init {
            img = view.findViewById(R.id.item_menu3_iv)
            tvTitle = view.findViewById(R.id.item_menu3_tvTitle)
        }

        fun setData(item: ItemMenu) {
            img.setImageResource(item.img)
            tvTitle.setText(item.title)

        }
    }
}