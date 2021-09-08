package com.example.tradix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_email.*

class EmailActivity : AppCompatActivity() {
    var handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)
        handler.postDelayed(CountThread(), 1000)
        email_btnResend.setOnClickListener {
            startActivity(Intent(this, ConfirmActivity::class.java))
            finish()
        }
    }

    inner class CountThread : Runnable {
        override fun run() {
            var count = email_tvNumber.text.toString().toInt() - 1
            email_tvNumber.text = count.toString()
            if (count == 0) {
                email_btnResend.isEnabled = true
                email_btnResend.setBackgroundResource(R.drawable.rettangolo_27)
            } else {
                handler.postDelayed(CountThread(), 1000)
            }
        }
    }
}