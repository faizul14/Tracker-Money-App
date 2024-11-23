package com.faezolmp.tracker_money_app.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TramoModel(
    val uid: Int?,
    val total: Long?,
    val statusMoney: String?, // in / out
    val description: String?,
    val date: String?,
) : Parcelable