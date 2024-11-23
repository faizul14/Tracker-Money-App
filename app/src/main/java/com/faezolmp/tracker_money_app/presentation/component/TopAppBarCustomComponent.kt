package com.faezolmp.tracker_money_app.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faezolmp.tracker_money_app.R

@Composable
fun TopAppBarCustomComponent(
    modifier: Modifier = Modifier, navigateToPayment: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(8.dp, 0.dp)
        ) {
            Text(
                text = "TraMo App", modifier = Modifier.weight(1f)
            )
            Text(
                text = "?", modifier = Modifier
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(painter = painterResource(R.drawable.baseline_payment_24),
                contentDescription = "payment Direction",
                tint = Color.Black,
                modifier = modifier
                    .size(34.dp)
                    .clickable {
                        navigateToPayment()
                    })
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TopAppBarCustomComponentPreview() {
    TopAppBarCustomComponent(navigateToPayment = {})
}