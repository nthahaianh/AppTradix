package com.example.tradix

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_confirm.*

private const val NAME_SHARE_PREFERENCES = "SharePreferences"

class ConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)
        var sharedPreferences: SharedPreferences = this.getSharedPreferences(
            NAME_SHARE_PREFERENCES,
            Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        confirm_btnLogin.setOnClickListener {
            editor.putString("spPassword","123")
            editor.apply()
            var intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("email", sharedPreferences.getString("spEmail","email"))
            intent.putExtra("password", sharedPreferences.getString("spPassword","123456"))
            startActivity(intent)
            finish()
        }
    }
}