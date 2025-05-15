package com.example.cobaproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cobaproject.ui.components.MainScreen
import com.example.cobaproject.ui.screen.LoginScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("login") { LoginScreen(navController) }
//        composable("register") { RegisterScreen(navController) }
        composable("main") { MainScreen() } // With BottomNav
    }
}