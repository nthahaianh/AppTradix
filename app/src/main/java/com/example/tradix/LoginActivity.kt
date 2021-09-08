package com.example.tradix

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*


private const val NAME_SHARE_PREFERENCES = "SharePreferences"

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val intent = this.intent
        val email = intent?.getStringExtra("email")
        val password = intent?.getStringExtra("password")
        login_etEmail.setText(email)
        login_etPassword.setText(password)

        login_tvSignUp.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SignUpActivity::class.java
                )
            )
        }
        login_tvForgot.setOnClickListener { startActivity(Intent(this, EmailActivity::class.java)) }

        login_btnLogin.setOnClickListener {
            var sharedPreferences: SharedPreferences = this.getSharedPreferences(
                NAME_SHARE_PREFERENCES,
                Context.MODE_PRIVATE
            )
            var email = login_etEmail.text.toString()
            var pass = login_etPassword.text.toString()

            var spEmail = sharedPreferences.getString("spEmail", "email")
            var spPassword = sharedPreferences.getString("spPassword", "123456")
            if (email == spEmail && pass == spPassword) {
                login()
            } else {
                Toast.makeText(this, "Incorrect account or password", Toast.LENGTH_LONG).show()
            }

        }
    }

    fun login() {
        var intent = Intent(this, MainActivity::class.java)
        finishAffinity()
        startActivity(intent)
    }

}