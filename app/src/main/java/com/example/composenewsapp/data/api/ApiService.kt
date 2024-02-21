package com.example.composenewsapp.data.api

import com.example.composenewsapp.data.entity.NewResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("country") country : String,
        @Query("apiKey") apiKey: String ="a32cae846b464c518cb75c520dc0bc61"
    ): Response<NewResponse>


}