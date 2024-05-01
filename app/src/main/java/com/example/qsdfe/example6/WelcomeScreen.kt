package com.example.week07.example6

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun WelcomeScreen(navController: NavHostController) {

    val navViewModel: NavViewModel = viewModel(viewModelStoreOwner = LocalNavGraphViewModelStoreOwner.current)
    val coroutineScope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Welcome Screen",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Text(
            text = "${navViewModel.userID}님 환영합니다.",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )

        LaunchedEffect(key1 = Unit) {
            navViewModel.loginStatus.value = true
            coroutineScope.launch {
                delay(2000)
                navController.navigate(Routes.Main.route)
            }
            if(navViewModel.loginStatus.value) {
                navController.navigate(Routes.Main.route) {
                    popUpTo(Routes.Login.route) {
                        inclusive = true // 로그인 시를 포함
                    }
                    launchSingleTop = true
                }
            }

        }
//        Button(onClick = {
//           navViewModel.loginStatus.value = true
//            coroutineScope.launch {
//                delay(2000)
//                navController.navigate(Routes.Main.route)
//            }
//        }) {
//            Text("메인화면")
//        }
    }
}