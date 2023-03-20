package com.example.retrofimvvm.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofimvvm.model.QuoteList
import com.example.retrofimvvm.repository.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.reflect.Array.get

class QuotesViewModel(private val repository: QuotesRepository) : ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getQuotes(1)
        }
    }

    val quotes:LiveData<QuoteList>
        get() = repository.quotes



}
