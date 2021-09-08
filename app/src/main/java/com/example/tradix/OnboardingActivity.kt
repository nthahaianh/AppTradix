package com.example.tradix

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_onboarding.*

private const val NUM_PAGES = 3
private const val NAME_SHARE_PREFERENCES = "SharePreferences"

class OnboardingActivity : AppCompatActivity() {
    private lateinit var mPager: ViewPager
    var handler = Handler(Looper.getMainLooper())

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        var sharedPreferences: SharedPreferences = this.getSharedPreferences(
                NAME_SHARE_PREFERENCES,
                Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        if (sharedPreferences.getBoolean("isDone", false)) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        mPager = viewpager
        val pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        mPager.adapter = pagerAdapter

        circleIndicator.setViewPager(mPager)

        if (mPager.currentItem == 0)
            onBoarding_ivBack.visibility = View.INVISIBLE
        else
            onBoarding_ivBack.visibility = View.VISIBLE

        onBoarding_tvSkip.setOnClickListener {
            editor.putBoolean("isDone", true)
            editor.apply()
            startActivity(
                    Intent(
                            this,
                            LoginActivity::class.java
                    )
            )
            finish()
        }
        onBoarding_ivBack.setOnClickListener {
            mPager.currentItem = mPager.currentItem - 1
            handler.post(MainThread())
        }

        viewpager.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_UP -> {
                    handler.post(MainThread())
                }
            }
            false
        }
        onBoarding_btnNext.setOnClickListener {
            if (mPager.currentItem == 2) {
                editor.putBoolean("isDone", true)
                editor.apply()
                startActivity(Intent(this, LoginActivity::class.java))
            } else {
                mPager.currentItem = mPager.currentItem + 1
                handler.post(MainThread())
            }
        }
    }

    override fun onBackPressed() {
        if (mPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            mPager.currentItem = mPager.currentItem - 1
            onBoarding_btnNext.text = "NEXT"
        }
    }

    inner class MainThread : Runnable {
        override fun run() {
            if (mPager.currentItem == 0)
                onBoarding_ivBack.visibility = View.INVISIBLE
            else
                onBoarding_ivBack.visibility = View.VISIBLE
            if (mPager.currentItem == 2)
                onBoarding_btnNext.text = "START"
            else
                onBoarding_btnNext.text = "NEXT"
        }
    }

    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) :
            FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = NUM_PAGES

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> return OnBoarding1Fragment()
                1 -> return OnBoarding2Fragment()
                else -> return OnBoarding3Fragment()
            }
        }
    }

}