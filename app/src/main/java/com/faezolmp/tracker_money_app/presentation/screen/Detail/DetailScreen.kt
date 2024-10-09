package com.faezolmp.tracker_money_app.presentation.screen.Detail

import StruckCard
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faezolmp.tracker_money_app.R
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    naviationToHome: () -> Unit,
    tramoData: TramoModel,
) {
//    Box (
//        modifier = modifier
//            .fillMaxSize()
//    ){
//        Column (
//            modifier = modifier
//                .fillMaxHeight(2.5f / 10f)
//                .fillMaxWidth()
//                .background(Color.Gray)
//        ){
//
//        }
//    }
//    Box(
//        modifier = modifier
//            .fillMaxWidth()
//            .fillMaxHeight(4f/10f)
//            .padding(8.dp)
//    ){
//        StruckCard(
//            painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_up_24)
//        )
//    }


    Column (
        modifier = modifier
            .fillMaxSize()
    ){
        Box (
            modifier = modifier
                .fillMaxHeight(2.5f / 10f)
                .fillMaxWidth()
                .background(Color.Black)
        ){
            Row(
                modifier = modifier.padding(start = 16.dp, top = 8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription ="arrow Back",
                    tint = Color.White,
                    modifier = modifier.clickable {
                        naviationToHome()
                    }
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    text = "Transaction ${tramoData.description}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    maxLines = 1,
                    modifier = modifier.fillMaxWidth(7f/10f)
                )
            }
        }
        Box(
            modifier = modifier.offset(0.dp, -150.dp)
        ){
            StruckCard(
                tramoData = tramoData,
                painter = painterResource(id = if (tramoData.statusMoney == "in") R.drawable.baseline_keyboard_double_arrow_down_24 else R.drawable.baseline_keyboard_double_arrow_up_24),
            )
        }
    }



}

@Preview(showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(naviationToHome = {}, tramoData = TramoModel(
        uid = 3867,
        total = 50_000L,
        statusMoney = "in",
        description = "WD Saham",
        date = "date"
    )
    )
}