package com.yildiz.mvvm_countrylist.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yildiz.mvvm_countrylist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.helloTextView.text = "Hello, View Binding!"
    }
}