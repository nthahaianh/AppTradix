package com.example.tradix

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_news_article.*
import kotlinx.android.synthetic.main.fragment_news_article.view.*

class NewsArticleFragmet : Fragment() {
    val args: NewsArticleFragmetArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_news_article, container, false)
        view.article_tvTitle.text = args.newsTitle
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        article_tvTitle.text = args.newsTitle
    }
}