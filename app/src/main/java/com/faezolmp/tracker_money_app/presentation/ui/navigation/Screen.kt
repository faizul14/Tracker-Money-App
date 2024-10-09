package com.faezolmp.tracker_money_app.presentation.ui.navigation

import com.faezolmp.tracker_money_app.core.domain.model.TramoModel

sealed class Screen(val router: String) {
    object Home: Screen("Home")
    object Detail: Screen("Detail/{tramo}"){
        fun createRoute(tramo: String) = "Detail/$tramo"
    }
    object Payment: Screen("Payment")
}