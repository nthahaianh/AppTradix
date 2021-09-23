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
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_coin.*
import kotlinx.android.synthetic.main.fragment_coin.view.*

class CoinFragment : Fragment() {
    var nameCoin: String? = "Index"
    val args:CoinFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_coin, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (args.name!=null)
            coin_tvTitle.text = args.name
        coin_btnAlarm.setOnClickListener {
            coin_btnAlarm.backgroundTintList = ColorStateList.valueOf(Color.rgb(
                java.util.Random().nextInt(255),
                java.util.Random().nextInt(255),
                java.util.Random().nextInt(255)
            ))
        }
    }
}