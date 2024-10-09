package com.faezolmp.tracker_money_app.presentation.screen.payment

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PaymentSecren(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit
) {
    Text(
        text = "Go Home Back",
        modifier = Modifier
            .clickable {
                navigateToHome()
            }
    )

}

@Preview(showSystemUi = true)
@Composable
fun PaymentSecrenPreview() {
    PaymentSecren (
        navigateToHome = {}
    )
}