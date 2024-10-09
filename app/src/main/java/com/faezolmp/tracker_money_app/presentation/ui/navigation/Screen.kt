package com.faezolmp.tracker_money_app.presentation.ui.navigation

sealed class Screen(val router: String) {
    object Home: Screen("Home")
    object Detail: Screen("Detail")
    object Payment: Screen("Payment")
}