package com.example.tradix

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.Adapter.AdapterCoinRV
import com.example.tradix.Adapter.AdapterTitleRV
import com.example.tradix.Model.Coin
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    private lateinit var coinList: MutableList<Coin>
    private lateinit var titleList : MutableList<String>
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var title_layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)

        view.home_ivSearch.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_coinFragment)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addData()
        var adapterCoinRV = AdapterCoinRV(coinList)
        var adapterTitleRV = AdapterTitleRV(titleList, "type1")
        layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )
        title_layoutManager = LinearLayoutManager(
            context,
            RecyclerView.HORIZONTAL,
            false
        )
        home_rvTitle.adapter = adapterTitleRV
        home_rvCoin.adapter = adapterCoinRV
        home_rvTitle.layoutManager = title_layoutManager
        home_rvCoin.layoutManager = layoutManager

        adapterCoinRV.setCallBack {
            val action = HomeFragmentDirections.actionHomeFragmentToCoinFragment(coinList[it].name)
            findNavController().navigate(action)
        }

        val itemTouchHelperCallBack = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, position: Int) {
                adapterCoinRV.remove(viewHolder)
            }

        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallBack)
        itemTouchHelper.attachToRecyclerView(view.home_rvCoin)

        home_btnLoadMore.setOnClickListener {
            add10Item()
            adapterCoinRV.notifyDataSetChanged()
        }

        home_btnAlarm.setOnClickListener {
            home_btnAlarm.backgroundTintList = ColorStateList.valueOf(
                Color.rgb(
                    java.util.Random().nextInt(255),
                    java.util.Random().nextInt(255),
                    java.util.Random().nextInt(255)
                )
            )
        }
    }

    private fun addData() {
        titleList = mutableListOf()
        titleList.add("INDEX")
        titleList.add("SHARES")
        titleList.add("CURRENCIES")
        titleList.add("FUTURES")
        titleList.add("CRYPTO")
        coinList = mutableListOf()
        coinList.add(Coin("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("FTSE 100", "LONDON", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("IBEX 35", "MADRID", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("DAX", "XETRA", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("FTSE 100", "LONDON", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("IBEX 35", "MADRID", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("DAX", "XETRA", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("FTSE 100", "LONDON", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("IBEX 35", "MADRID", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("DAX", "XETRA", "10:44:45", "20.047,50", "+203 (+1,04%)"))
    }

    private fun add10Item() {
        coinList.add(Coin("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("FTSE 100", "LONDON", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("IBEX 35", "MADRID", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("DAX", "XETRA", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("FTSE 100", "LONDON", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("IBEX 35", "MADRID", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("DAX", "XETRA", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        coinList.add(Coin("FTSE 100", "LONDON", "10:44:45", "20.047,50", "+203 (+1,04%)"))
    }

}