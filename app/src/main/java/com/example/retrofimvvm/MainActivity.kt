package com.example.retrofimvvm

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.retrofimvvm.adapters.QuotesAdapter
import com.example.retrofimvvm.databinding.ActivityMainBinding
import com.example.retrofimvvm.model.Results
import com.example.retrofimvvm.viewModels.QuotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val quotesViewModel: QuotesViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    // lateinit var quotesViewModel: QuotesViewModel
    /* lateinit var adapter: QuotesAdapter*/
    private val addQoutes = ArrayList<Results>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        quotesViewModel.quotes.observe(this, Observer {
            Log.d("TeraFort", "" + it.results)
            binding.recyclerView.adapter = QuotesAdapter(it.results)

        })
    }
}