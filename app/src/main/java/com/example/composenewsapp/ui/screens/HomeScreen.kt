package com.example.composenewsapp.ui.screens

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.composenewsapp.data.entity.NewResponse
import com.example.composenewsapp.ui.components.LoadDataButton
import com.example.composenewsapp.ui.components.Loader
import com.example.composenewsapp.ui.components.NewsList
import com.example.composenewsapp.ui.components.NewsRowComponent
import com.example.composenewsapp.ui.components.WhatsappPath
import com.example.composenewsapp.ui.navigation.Routes
import com.example.composenewsapp.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState

const val TAG = "HomeScreen"
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    mViewModel: NewsViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController()
)
{

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let {
                imageUri = it
            }
        }
    )
    val news by mViewModel.news.collectAsState()
    val pagerState = rememberPagerState(0, 0f){
        20
    }




    /*VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp

    ) {page: Int ->
            when(news){
                is ResourceState.Loading -> {
                    Log.d(TAG, "HomeScreen: Loading")
                    Loader()
                }
                is ResourceState.Success ->{
                    Log.d(TAG, "HomeScreen: Success")
                    val res = (news as ResourceState.Success<NewResponse>).data
                    Log.d(TAG, "HomeScreen: status -> ${res.status}, --> size - > ${res.totalResults} article size -> ${res.articles.size}")
                    //NewsList(res)
                    if(res.articles.isNotEmpty() && res.articles.size  < res.totalResults){
                    NewsRowComponent(page, res.articles.get(page)){
                        navController.navigate(route = Routes.NEXT_SCREEN)
                    }
                    }
                }
                is ResourceState.Error -> {
                    Log.d(TAG, "HomeScreen: Error")

                }
            }



    }


    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        imageUri?.let {

            Image(painter = rememberAsyncImagePainter(model = imageUri), contentDescription = "")

        }

        LoadDataButton(){
            galleryLauncher.launch("image/*")
        }

    }*/*/

   WhatsappPath()


}




@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}