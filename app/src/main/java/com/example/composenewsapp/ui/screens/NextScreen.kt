package com.example.composenewsapp.ui.screens

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composenewsapp.data.entity.NewResponse
import com.example.composenewsapp.ui.components.LoadDataButton
import com.example.composenewsapp.ui.components.Loader
import com.example.composenewsapp.ui.components.NewsList
import com.example.composenewsapp.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState

@Composable
fun NextScreen(
    mViewModel: NewsViewModel = hiltViewModel()
) {
    val TAG = "NextScreen"
    val nextNews by mViewModel.nextNews.collectAsState()
    var visible by rememberSaveable { mutableStateOf(true) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = androidx.compose.ui.Modifier.fillMaxSize()
    ) {
        AnimatedVisibility(visible = visible) {
            LoadDataButton() {
                mViewModel.getNextNewsData("in")
            }
        }

        when (nextNews) {
            is ResourceState.Loading -> {
                Log.d(TAG, "NextScreen: Loading and visibilty -> $visible")
                Loader(!visible)
                visible = false
            }

            is ResourceState.Success -> {
                Log.d(TAG, "NextScreen: Success")
                val res = (nextNews as ResourceState.Success<NewResponse>).data
                Log.d(TAG, "HomeScreen: status -> ${res.status}, --> size - > ${res.totalResults}")
                NewsList(res, false) {

                }
            }

            is ResourceState.Error -> {
                Log.d(TAG, "NextScreen: Error")

            }

        }

    }


}