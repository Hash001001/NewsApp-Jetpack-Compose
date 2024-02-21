package com.example.composenewsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenewsapp.ui.screens.HomeScreen
import com.example.composenewsapp.ui.screens.NextScreen

@Composable
fun AppNavigationGraph(){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN){
        composable(route = Routes.HOME_SCREEN){
            HomeScreen(navController = navController)
        }

        composable(route = Routes.NEXT_SCREEN){
            NextScreen()
        }

    }
}