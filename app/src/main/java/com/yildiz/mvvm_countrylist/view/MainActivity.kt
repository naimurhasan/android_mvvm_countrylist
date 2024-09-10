package com.yildiz.mvvm_countrylist.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.yildiz.mvvm_countrylist.R
import com.yildiz.mvvm_countrylist.adapter.CountryBasicAdapter
import com.yildiz.mvvm_countrylist.databinding.ActivityMainBinding
import com.yildiz.mvvm_countrylist.viewmodel.CountryBasicListViewModel
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CountryBasicListViewModel by viewModels()
    private lateinit var adapter: CountryBasicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CountryBasicAdapter(this, ArrayList())
        binding.listview.adapter = adapter

        // observe
        viewModel.countryList.observe(this) { countries ->
            adapter.updateCountries(countries)
        }

        viewModel.refresh();


    }
}
