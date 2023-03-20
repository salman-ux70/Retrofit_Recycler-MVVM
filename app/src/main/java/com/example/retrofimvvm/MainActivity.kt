package com.example.retrofimvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofimvvm.adapters.QuotesAdapter
import com.example.retrofimvvm.api.QuoteService
import com.example.retrofimvvm.api.RetrofitHelper
import com.example.retrofimvvm.databinding.ActivityMainBinding
import com.example.retrofimvvm.model.Results
import com.example.retrofimvvm.repository.QuotesRepository
import com.example.retrofimvvm.viewModels.QuotesViewModel
import com.example.retrofimvvm.viewModels.QuotesViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var quotesViewModel: QuotesViewModel
    lateinit var adapter: QuotesAdapter
    private val addQoutes = ArrayList<Results>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository = QuotesRepository(quoteService)
        quotesViewModel = ViewModelProvider(this,QuotesViewModelFactory(repository)).get(QuotesViewModel::class.java)
        quotesViewModel.quotes.observe(this, Observer {
            Log.d("TeraFort",""+it.results)
            binding.recyclerView.adapter = QuotesAdapter(it.results)

        })
    }
}