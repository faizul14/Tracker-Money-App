package com.faezolmp.tracker_money_app

import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import com.faezolmp.tracker_money_app.presentation.component.TopAppBarCustomComponent
import com.faezolmp.tracker_money_app.presentation.screen.Detail.DetailScreen
import com.faezolmp.tracker_money_app.presentation.screen.Home.HomeScreen
import com.faezolmp.tracker_money_app.presentation.screen.payment.PaymentSecren
import com.faezolmp.tracker_money_app.presentation.ui.navigation.Screen
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TramoApp(
    modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = navBackStackEntry?.destination?.route
    Scaffold(topBar = {
        if (currentScreen == Screen.Home.router) {
            TopAppBar(title = {
                TopAppBarCustomComponent(navigateToPayment = {
                    navController.navigate(Screen.Payment.router)
                })
            })
        }
    }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.router,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(
                Screen.Home.router
            ) {
                HomeScreen(navigationToDetail = { tramodelData ->
                    val jsonTramo = Uri.encode(Gson().toJson(tramodelData))
                    navController.navigate(Screen.Detail.createRoute(jsonTramo))
                })
            }
            composable(
                Screen.Payment.router
            ) {
                PaymentSecren(navigateToHome = {
                    navController.popBackStack()
                })
            }
            composable(
                Screen.Detail.router,
                arguments = listOf(navArgument("tramo") { type = NavType.StringType })
            ) { navBackStackEntry ->
                val jsonTramo = navBackStackEntry.arguments?.getString("tramo")
                val tramo = Gson().fromJson(jsonTramo, TramoModel::class.java)
                DetailScreen(
                    naviationToHome = { navController.popBackStack() }, tramoData = tramo
                )
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun TramoAppPreview() {
    TramoApp()
}