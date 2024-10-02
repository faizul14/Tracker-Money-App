package com.faezolmp.tracker_money_app.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExampleModel(
    val dataExample: String = "example"
) : Parcelable