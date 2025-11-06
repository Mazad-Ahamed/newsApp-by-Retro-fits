package com.example.newsreader.Api

import com.example.newsreader.Data.NewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface NewsApi {
    @GET("top-headlines?category=general&lang=en&apikey=355d66428f37531ca8eec13f7d02c1e4")
    fun getTopHeadlines(): Call<NewsResponse>
}