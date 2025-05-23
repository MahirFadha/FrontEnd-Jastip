package com.example.cobaproject.ui.screen.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cobaproject.R
import com.example.cobaproject.ui.screen.loginscreen.LoginScreen

@Composable
fun RegisterScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel = hiltViewModel()) {
    var state = viewModel.state
    var name by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp, start = 24.dp, end = 24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Selamat Datang di Aplikasi Jastip", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(30.dp))

        // Nama
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nama") },
            placeholder = { Text("Masukkan nama", color = Color.Gray) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.round_account_circle_24),
                    contentDescription = null,
                    tint = Color.Gray
                )
            },
            visualTransformation = VisualTransformation.None,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        // NIM
        OutlinedTextField(
            value = nim,
            onValueChange = { nim = it },
            label = { Text("NIM") },
            placeholder = { Text("Masukkan NIM", color = Color.Gray) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.round_assignment_ind_24),
                    contentDescription = null,
                    tint = Color.Gray
                )
            },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        // Password
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            placeholder = { Text("Masukkan password", color = Color.Gray) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.lock),
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(25.dp) // Atur ukuran ikon di sini
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.eye),
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(25.dp) // Ukuran ikon trailing
                        .clickable { passwordVisible = !passwordVisible }
                )
            },
            visualTransformation = if (!passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Tombol Daftar
        Button(
            onClick = { viewModel.register(name,nim,password) },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F7D58))
        ) {
            Text(text = "Sign Up", color = Color.White, fontSize = 16.sp)
        }
        when{
            state.isLoading -> CircularProgressIndicator()
            state.succes -> Text("Selamat datang ${state.user?.name}")
            state.error != null -> Text("Error: ${state.error}")
        }

        LaunchedEffect(key1 = state.succes) {
            if (state.succes)
                navController.navigate("login"){
                    popUpTo("register"){
                        inclusive = true
                    }
                }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Text(
                text = "Sudah punya akun?",
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Masuk Sekarang",
                fontSize = 12.sp,
                color = Color.Blue,
                modifier = Modifier.clickable {
                    navController.navigate("login")
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreenPreview() {
    val navController = rememberNavController() // dummy controller
    RegisterScreen(navController = navController)
}

@Composable
fun MainNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "akun") {
        composable("register") { RegisterScreen(navController) }
        composable("login") { LoginScreen(navController) }
    }
}

