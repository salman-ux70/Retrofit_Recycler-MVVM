package com.example.retrofimvvm.api

import com.example.retrofimvvm.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

interface QuoteService {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page")page:Int) : Response<QuoteList>
}