package com.example.composenewsapp.data.dataSource

import com.example.composenewsapp.data.entity.NewResponse
import retrofit2.Response
import retrofit2.http.Query

interface NewsDataSource {

    suspend fun getNews(country : String): Response<NewResponse>

}