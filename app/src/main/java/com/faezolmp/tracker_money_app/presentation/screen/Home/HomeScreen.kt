package com.faezolmp.tracker_money_app.presentation.screen.Home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faezolmp.tracker_money_app.R
import com.faezolmp.tracker_money_app.core.data.Resource
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import com.faezolmp.tracker_money_app.core.utils.FormatMoney
import com.faezolmp.tracker_money_app.presentation.component.FilterChipComponent
import com.faezolmp.tracker_money_app.presentation.component.ItemTramoComponent
import com.faezolmp.tracker_money_app.presentation.di.appModule
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinApplication
import java.text.Format

//@Composable
//fun HomeScreen(
//    viewModel: HomeViewModel = koinViewModel(), modifier: Modifier = Modifier
//) {
//
//    val dataState by viewModel.dataState.collectAsState()
//    when (dataState) {
//        is Resource.Loading -> {
//            CircularProgressIndicator()
//        }
//
//        is Resource.Success -> {
//            val data = (dataState as Resource.Success).data
//            if (data != null) {
//                DataList(data)
//            }
//        }
//
//        is Resource.Error -> {
//            Text(text = (dataState as Resource.Error).message ?: "An error occurred")
//        }
//    }
//}
//
@Composable
fun DataList(data: List<TramoModel>, navigationToDetail: (TramoModel) -> Unit) {
    val reversedData = data.reversed()
    // Menggunakan LazyListState untuk mengatur posisi scroll
    val listState = rememberLazyListState()

    // Efek yang dijalankan setiap kali data berubah
    LaunchedEffect(reversedData) {
        // Scroll ke item pertama (atas) ketika data baru ditambahkan
        listState.scrollToItem(0)
    }
    LazyColumn(state = listState, contentPadding = PaddingValues(top = 2.dp )) {
        items(reversedData, key = {it.date.toString()}) { item ->
            ItemTramoComponent(tramo = item, navigationToDetail = {navigationToDetail(it)})

//            Text(text = item.toString())
//            Text(text = "ID: ${item.uid}, Total: ${item.total}, Status: ${item.statusMoney}, Date: ${item.date}, Threa ${Thread.currentThread().name}")
        }
    }
}

val FilterData = listOf<String>("All", "in", "out")

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    modifier: Modifier = Modifier,
    navigationToDetail: (TramoModel) -> Unit
) {
    var stateDataFilter by rememberSaveable {
        mutableStateOf("All")
    }
    val dataState by viewModel.dataState.collectAsState()
    val moneyIn by viewModel.moneyIn.collectAsState()
    val moneyOut by viewModel.moneyOut.collectAsState()
    val countTrasaction by viewModel.dataTransaction.collectAsState()
//    val transactionState by viewModel.dataTransaction.collectAsState()

    Column(
        horizontalAlignment = Alignment.Start, modifier = modifier
    ) {
        Divider(
            thickness = 1.dp,
            color = Color.Black
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(2f / 10f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = modifier
                    .fillMaxHeight()
                    .fillMaxWidth(7f / 10f)
                    .padding(top = 16.dp)
            ) {
//                Text(
//                    text = "Cuan Diary",
//                    fontSize = 24.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                )

//                Box(
//                    modifier = modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(
//                        text = "/ / / / / / / / /",
//                        fontSize = 40.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.Black,
//                        modifier = modifier,
////                            .fillMaxHeight()
////                            .align(Alignment.CenterVertically),
//                        lineHeight = 60.sp // menambah jarak antar baris
//                    )
//                }
                Row {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = modifier.weight(1f),
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_circle_down_24),
                            contentDescription = "in",
                            tint = Color.Green
                        )
                        Spacer(modifier = modifier.width(4.dp))
                        Text(
                            text = "Uang Masuk",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = modifier.weight(1f),
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_circle_up_24),
                            contentDescription = "out",
                            tint = Color.Red
                        )
                        Spacer(modifier = modifier.width(4.dp))
                        Text(
                            text = "Uang Keluar",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
                Spacer(modifier = modifier.height(8.dp))
                Row {
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = modifier.weight(1f),
                    ) {
                        Spacer(modifier = modifier.width(8.dp))
                        Text(
                            text = FormatMoney.formatCurrency(moneyIn),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                            color = Color.Green
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = modifier.weight(1f),
                    ) {
                        Spacer(modifier = modifier.width(8.dp))
                        Text(
                            text = FormatMoney.formatCurrency(moneyOut),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                            color = Color.Red
                        )
                    }
                }

                Spacer(modifier = modifier.height(16.dp))
                Row {
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center,
                        modifier = modifier.weight(1f),
                    ) {
                        Spacer(modifier = modifier.width(8.dp))
                        Text(
                            text = "SALDO ANDA: ${moneyIn - moneyOut}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                        )
                    }
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.Center,
//                        modifier = modifier.weight(1f),
//                    ) {
//                        Spacer(modifier = modifier.width(8.dp))
//                        Text(
//                            text = FormatMoney.formatCurrency(moneyOut),
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Medium,
//                            textAlign = TextAlign.Center,
//                        )
//                    }
                }
            }
            Text(
                text = countTrasaction.toString(),
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .weight(1f)
                    .padding(4.dp)
                    .align(Alignment.CenterVertically)
                    .clickable { viewModel.insetDumyData() }

            )
        }

        LazyRow(
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(FilterData) { item ->
                FilterChipComponent(
                    selected = stateDataFilter == item,
                    label = item,
                    onSelected = { selected ->
//                    if (selected) stateDataFilter.add(item) else stateDataFilter.remove(item)
                        if (selected) stateDataFilter = item
                        viewModel.FilterData(stateDataFilter)
                    })
            }
        }
        Divider(
            thickness = 1.dp,
            color = Color.Black
        )
        Text(
            text = "Home Screen ${stateDataFilter}",
            modifier = modifier.padding(start = 8.dp)
        )
//        FilterChipComponent(label = "#FilterALL", onSelected = { selected ->
////            if (selected) stateDataFilter.add("#FilterALL") else stateDataFilter.remove("#FilterALL")
//            if (selected) stateDataFilter = "FilterALL" else stateDataFilter = "All"
//        })

        when (dataState) {
            is Resource.Loading -> {
                Box(
                    modifier = modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    LinearProgressIndicator()
                }
            }

            is Resource.Success -> {
                val data = (dataState as Resource.Success).data
                if (data != null) {
                    DataList(data, navigationToDetail = {navigationToDetail(it)})
                }
            }

            is Resource.Error -> {
                Text(text = (dataState as Resource.Error).message ?: "An error occurred")
            }
        }
    }


}


@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    KoinApplication(application = {
        modules(appModule)
    }) {
        HomeScreen(navigationToDetail = {})
    }

}

