package com.faezolmp.tracker_money_app.presentation.component.componentPayment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.faezolmp.tracker_money_app.R

@Composable
fun SuccesDialog(modifier: Modifier = Modifier, description: String) {
    Dialog(onDismissRequest = {}) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(4f / 10f)
                        .align(Alignment.TopCenter)
                        .background(Color.Black)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_cloud_done_24),
                        contentDescription = "icon succes insert data",
                        tint = Color.Green,
                        modifier = modifier.align(Alignment.Center)
                    )

                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .align(Alignment.BottomCenter)
                        .offset(0.dp, -80.dp)
                ) {
                    Text(
                        text = "Payment Succes", color = Color.Black, fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = description,
                        fontSize = 10.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        modifier = modifier.fillMaxWidth(6f / 10f)
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = false)
@Composable
private fun SuccesDialogPreview() {
    SuccesDialog(description = "Lorem Ipsum dolor sit amet")
}