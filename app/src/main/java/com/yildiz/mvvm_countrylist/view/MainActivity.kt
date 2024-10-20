package com.yildiz.mvvm_countrylist.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.yildiz.mvvm_countrylist.adapter.CountryAdapter
import com.yildiz.mvvm_countrylist.databinding.ActivityMainBinding
import com.yildiz.mvvm_countrylist.viewmodel.CountryListViewModel
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CountryListViewModel by viewModels()
    private lateinit var countryAdapter : CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.countryList.observe(this, Observer { countryList ->
            countryAdapter = CountryAdapter(countryList)
            binding.recyclerView.adapter = countryAdapter
        })

        viewModel.isLoading.observe(this, Observer { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        })

        viewModel.refresh()
    }
}
