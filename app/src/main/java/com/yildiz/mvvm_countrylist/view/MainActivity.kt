package com.yildiz.mvvm_countrylist.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.yildiz.mvvm_countrylist.databinding.ActivityMainBinding
import com.yildiz.mvvm_countrylist.viewmodel.CountViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val countViewModel: CountViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.helloTextView.text = "Hello, View Binding!"

        binding.actionButton.setOnClickListener {
            countViewModel.increment();
        }

        countViewModel.countModel.observe(this){
            countModel -> binding.helloTextView.text = "Count: ${countModel.count}"
        }
    }
}