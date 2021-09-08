package com.example.tradix

import android.app.ActivityManager
import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navHostFragment: NavHostFragment
    lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        controller = navHostFragment.navController
        main_bottomNavigationView.setupWithNavController(controller)
    }

    override fun onBackPressed() {
        if (navHostFragment.childFragmentManager.backStackEntryCount == 0) {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Are you sure?")
                .setMessage("Do you want to exit app?")
                .setNegativeButton("No") { _: DialogInterface, _: Int -> }
                .setPositiveButton("Yes") { _: DialogInterface, _: Int ->
                    finish()
                }
                .show()
        } else {
            super.onBackPressed()
        }
    }

}