package com.faezolmp.tracker_money_app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.faezolmp.tracker_money_app.presentation.component.TopAppBarCustomComponent
import com.faezolmp.tracker_money_app.presentation.screen.Home.HomeScreen
import com.faezolmp.tracker_money_app.presentation.screen.payment.PaymentSecren
import com.faezolmp.tracker_money_app.presentation.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TramoApp(
    modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = navBackStackEntry?.destination?.route
    Scaffold(topBar = {
        TopAppBar(title = {
            TopAppBarCustomComponent(navigateToPayment = {
                navController.navigate(Screen.Payment.router)
            }, navigateToPaid = {

            })
        })
    }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.router,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(
                Screen.Home.router
            ) {
                HomeScreen()
            }
            composable(
                Screen.Payment.router
            ) {
                PaymentSecren(navigateToHome = {
                    navController.popBackStack()
                })
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun TramoAppPreview() {
    TramoApp()
}