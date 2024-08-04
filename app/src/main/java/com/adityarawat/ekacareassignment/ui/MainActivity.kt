package com.adityarawat.ekacareassignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.adityarawat.ekacareassignment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Splash Screen to DashBoard Screen
        navHandler()
    }

    private fun navHandler() {
        Handler(Looper.myLooper()!!).postDelayed({
            binding.fragmentContainerView.visibility = View.VISIBLE
            binding.splash.visibility = View.GONE
        },3000)
    }
}