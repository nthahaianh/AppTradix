package com.example.tradix

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.Adapter.AdapterMenuRV
import com.example.tradix.Model.ItemMenu
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment() {
    private lateinit var itemMenuList: MutableList<ItemMenu>
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_menu, container, false)

        addData()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapterMenuRV = AdapterMenuRV(itemMenuList)
        layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )
        menu_rvMenu.adapter = adapterMenuRV
        menu_rvMenu.layoutManager = layoutManager
    }

    private fun addData() {
        itemMenuList = mutableListOf()
        itemMenuList.add(ItemMenu(R.drawable.icons_8_alarm, "Alerts", 1))
        itemMenuList.add(ItemMenu(R.drawable.icons_8_left_and_right_arrows, "Predictions", 1))
        itemMenuList.add(ItemMenu(R.drawable.icons_8_pin, "Saved elements", 1))
        itemMenuList.add(ItemMenu(R.drawable.icons_8_no_entry, "Remove Ads", 1))
        itemMenuList.add(ItemMenu(0, "Tools", 2))
        itemMenuList.add(ItemMenu(R.drawable.icons_8_profit_2, "Select Stocks", 3))
        itemMenuList.add(ItemMenu(R.drawable.icons_8_swap, "Currency Exchange", 3))
        itemMenuList.add(ItemMenu(R.drawable.icons_8_video_call, "Webinar", 3))
        itemMenuList.add(ItemMenu(R.drawable.icons_8_rent, "Best Broker", 3))
        itemMenuList.add(ItemMenu(0, "Markets", 2))
        itemMenuList.add(ItemMenu(R.drawable.icons_8_profit_2, "Select Stocks", 3))
        itemMenuList.add(ItemMenu(R.drawable.icons_8_swap, "Currency Exchange", 3))
        itemMenuList.add(ItemMenu(R.drawable.icons_8_video_call, "Webinar", 3))
        itemMenuList.add(ItemMenu(R.drawable.icons_8_rent, "Best Broker", 3))
    }
}