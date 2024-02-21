package com.example.composenewsapp.ui.repository

import com.example.composenewsapp.data.dataSource.NewsDataSource
import com.example.composenewsapp.data.entity.NewResponse
import com.example.utilities.ResourceState
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDataSource: NewsDataSource
) {

    suspend fun getNews(country: String) = flow {

        emit(ResourceState.Loading<NewResponse>())

        kotlinx.coroutines.delay(2000)

        val response = newsDataSource.getNews(country)
        if (response.isSuccessful && response.body() != null) {
            emit(ResourceState.Success<NewResponse>(response.body()!!))
        } else {
            emit(ResourceState.Error("Error occur"))
        }
    }
}