package com.example.composenewsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenewsapp.data.AppConstant
import com.example.composenewsapp.data.entity.NewResponse
import com.example.composenewsapp.ui.repository.NewsRepository
import com.example.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.concurrent.Flow
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _news: MutableStateFlow<ResourceState<NewResponse>> =
        MutableStateFlow(ResourceState.Loading())
    val news: StateFlow<ResourceState<NewResponse>> = _news

    private val _nextNews: MutableStateFlow<ResourceState<NewResponse>> =
        MutableStateFlow(ResourceState.Loading())
    val nextNews: StateFlow<ResourceState<NewResponse>> = _nextNews

    init {
        getNews(AppConstant.Country)
    }

    fun getNews(country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNews(country)
                .collectLatest {
                    _news.value = it
                }
        }
    }

    fun getNextNewsData(country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNews(country)
                .collectLatest {
                    _nextNews.value = it
                }
        }
    }

}