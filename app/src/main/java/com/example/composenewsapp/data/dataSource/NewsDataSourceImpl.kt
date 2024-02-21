package com.example.composenewsapp.data.dataSource

import com.example.composenewsapp.data.api.ApiService
import com.example.composenewsapp.data.entity.NewResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : NewsDataSource {

    override suspend fun getNews(country: String): Response<NewResponse> {
        return apiService.getNews(country)
    }


}