package com.example.cobaproject.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cobaproject.R
import com.example.cobaproject.ui.screen.ActivityScreen
import com.example.cobaproject.ui.screen.AkunScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedItem = currentRoute ?: "",
                navController = navController
            )
        }
    ) { innerPadding ->
        // Ini penting: padding diterapkan di sini agar tidak tertutup tombol sistem
        NavHost(
            navController = navController,
            startDestination = "akun",
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            composable("akun") { AkunScreen(navController) }
            composable("aktivitas") { ActivityScreen(navController) }
            composable("beranda") { /* BerandaScreen(navController) */ }
        }
    }
}



@Composable
fun BottomNavigationBar(
    selectedItem: String,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF3F7D58))
            .navigationBarsPadding(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavItem(
            icon = R.drawable.beranda,
            label = "Beranda",
            isSelected = selectedItem == "beranda",
            modifier = Modifier.weight(1f),
            onClick = { navController.navigate("beranda") }
        )
        BottomNavItem(
            icon = R.drawable.order,
            label = "Aktivitas",
            isSelected = selectedItem == "aktivitas",
            modifier = Modifier.weight(1f),
            onClick = { navController.navigate("aktivitas") }
        )
        BottomNavItem(
            icon = R.drawable.round_account_circle_24,
            label = "Akun",
            isSelected = selectedItem == "akun",
            modifier = Modifier.weight(1f),
            onClick = { navController.navigate("akun") }
        )
    }
}


@Composable
fun BottomNavItem(
    icon: Int,
    label: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clickable { onClick() }
            .padding(top = 8.dp, bottom = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = label,
            tint = if (isSelected) Color.White else Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = label,
            fontSize = 12.sp,
            color = if (isSelected) Color.White else Color.Gray
        )
        if (isSelected) {
            Divider(
                color = Color.White,
                thickness = 2.dp,
                modifier = Modifier
                    .width(24.dp)
                    .padding(top = 4.dp)
            )
        } else {
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}

