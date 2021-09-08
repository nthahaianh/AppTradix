package com.example.tradix

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*

private const val NAME_SHARE_PREFERENCES = "SharePreferences"

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        signup_tvLogin.setOnClickListener { finish() }
        signup_btnSignUp.setOnClickListener {
            var sharedPreferences: SharedPreferences = this.getSharedPreferences(
                NAME_SHARE_PREFERENCES,
                Context.MODE_PRIVATE
            )
            val editor = sharedPreferences.edit()
            editor.putString("spEmail", signup_etEmail.text.toString())
            editor.putString("spPassword", signup_etPassword.text.toString())
            editor.apply()
            var intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("email", signup_etEmail.text.toString())
            intent.putExtra("password", signup_etPassword.text.toString())
            finishAffinity()
            startActivity(intent)
        }
        signup_tvForgot.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    EmailActivity::class.java
                )
            )
        }
    }
}