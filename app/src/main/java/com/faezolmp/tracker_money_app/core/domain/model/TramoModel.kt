package com.faezolmp.tracker_money_app.core.domain.model

data class TramoModel(
    val uid: Int = 0,
    val total: Long?,
    val statusMoney: String?, // in / out
    val date: String?, // in / out
)