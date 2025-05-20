package com.example.cobaproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cobaproject.ui.components.MainScreen
import com.example.cobaproject.ui.screen.*
import com.example.cobaproject.ui.screen.LoginScreen.LoginScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "main",
        modifier = Modifier
    ) {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("signUp") {
            SignUpScreen(navController = navController)
        }
        composable("main") {
            MainScreen(parentNavController = navController)
        }

        // Halaman bukan bagian dari bottom nav
        composable("pagi") {
            PagiScreen(navController = navController)
        }
        composable("siang") {
            SiangScreen(navController = navController)
        }
        composable("sore") {
            SoreScreen(navController = navController)
        }
        composable("edit_profile") {
            EditPfScreen(navController = navController)
        }
        composable("keranjang") {
            KeranjangScreen(navController = navController)
        }
    }
}


