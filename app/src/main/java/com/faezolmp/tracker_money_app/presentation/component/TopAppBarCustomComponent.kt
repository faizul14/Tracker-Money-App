package com.faezolmp.tracker_money_app.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopAppBarCustomComponent(
    modifier: Modifier = Modifier,
    navigateToPayment:() -> Unit,
    navigateToPaid: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
//            .padding(8.dp)
    ) {
        Row (
            modifier = modifier
                .padding(8.dp, 0.dp)
        ){
            Text(
                text = "TraMo App", modifier = Modifier.weight(1f)
            )
            Text(
                text = "?", modifier = Modifier
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "+", modifier = Modifier
                    .weight(0.1f)
                    .clickable { navigateToPaid() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "-", modifier = Modifier
                    .weight(0.1f)
                    .clickable { navigateToPayment() }
            )
        }
//        Divider(
//            thickness = 1.dp,
//            color = Color.Black
//        )

    }
}

@Preview(showSystemUi = true)
@Composable
fun TopAppBarCustomComponentPreview() {
//    TopAppBarCustomComponent(navigateToPayment = {})
}