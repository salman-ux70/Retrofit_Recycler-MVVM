package com.example.retrofimvvm.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofimvvm.model.QuoteList
import com.example.retrofimvvm.repository.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.reflect.Array.get
import javax.inject.Inject


@HiltViewModel
class QuotesViewModel @Inject constructor(private val repository: QuotesRepository) : ViewModel() {
    var mutable:MutableLiveData<QuoteList>?=null
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }

    val quotes: LiveData<QuoteList>
        get() = repository.quotes
}
