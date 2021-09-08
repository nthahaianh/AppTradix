package com.example.tradix

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tradix.Adapter.AdapterNewsRV
import com.example.tradix.Adapter.AdapterTitleRV
import com.example.tradix.Model.News
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_news.view.*

class NewsFragment : Fragment() {
    private lateinit var newsList: MutableList<News>
    private lateinit var titleList: MutableList<String>
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var title_layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_news, container, false)
        addData()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapterNews = AdapterNewsRV(newsList)
        var adapterTitleRV = AdapterTitleRV(titleList, "type2")
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
        news_rvTitle.adapter = adapterTitleRV
        news_rvNews.adapter = adapterNews
        news_rvTitle.layoutManager = title_layoutManager
        news_rvNews.layoutManager = layoutManager

        adapterNews.setCallBack {
            var title = newsList[it].title
            val action = NewsFragmentDirections.actionNewsFragmentToNewsArticleFragmet(title)
            findNavController().navigate(action)
        }
    }

    private fun addData() {
        titleList = mutableListOf()
        titleList.add("EDITORIAL")
        titleList.add("CRYPTO NEWS")
        titleList.add("RAW MATERIAL")
        titleList.add("ECONOMICS")
        newsList = mutableListOf()
        newsList.add(
            News(
                R.drawable.img2390177,
                "ALT -3,87%",
                "3 Sept 2020",
                "ATLANTIA",
                "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus"
            )
        )
        newsList.add(
            News(
                R.drawable.img2351087,
                "HKD -2,13%",
                "2 Sept 2020",
                "XIAOMI",
                "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus"
            )
        )
        newsList.add(
            News(
                R.drawable.img2390206,
                "AAPL -0,91%",
                "1 Sept 2020",
                "APPLE",
                "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus"
            )
        )
    }

}