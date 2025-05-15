package com.example.cobaproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cobaproject.ui.components.MainScreen
import com.example.cobaproject.ui.screen.AkunScreen
import com.example.cobaproject.ui.screen.BerandaScreen
import com.example.cobaproject.ui.screen.LoginScreen
import com.example.cobaproject.ui.screen.PagiScreen
import com.example.cobaproject.ui.screen.SignUpScreen
import com.example.cobaproject.ui.theme.CobaProjectTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
//        WindowCompat.setDecorFitsSystemWindows(window, false)

        enableEdgeToEdge()
        setContent {
            CobaProjectTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    MainScreen()
                }
            }
        }
    }
}
////                // Inisialisasi NavController
//                val navController = rememberNavController()
////
////                // Scaffold dengan NavHost untuk navigasi
//                Scaffold(
//                    modifier = Modifier.fillMaxSize()
//                ) { innerPadding ->
//                    // Menambahkan NavHost yang mengatur navigasi antar screen
//                    NavHost(
//                        navController = navController,
//                        startDestination = "beranda", // Halaman pertama yang ditampilkan
//                        modifier = Modifier.padding(innerPadding)
//                    ) {
//                        // Komponen untuk SignUpScreen
//                        composable("signUp") {
//                            SignUpScreen(navController = navController) // Panggil SignUpScreen dengan navController
//                        }
//                        composable("login") {
//                            LoginScreen(navController = navController) // Pastikan LoginScreen terdaftar
//                        }
//                        composable("akun") {
//                            AkunScreen(navController = navController)
//                        }
//                        composable("pagi") {
//                            PagiScreen(navController = navController)
//                        }
//                        composable("beranda") {
//                            BerandaScreen(navController = navController)
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
