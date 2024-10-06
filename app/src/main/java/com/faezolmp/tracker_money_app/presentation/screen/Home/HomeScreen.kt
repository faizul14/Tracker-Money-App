package com.faezolmp.tracker_money_app.presentation.screen.Home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.faezolmp.tracker_money_app.core.data.Resource
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(), modifier: Modifier = Modifier
) {

    val dataState by viewModel.dataState.collectAsState()
    when (dataState) {
        is Resource.Loading -> {
            CircularProgressIndicator()
        }

        is Resource.Success -> {
            val data = (dataState as Resource.Success).data
            if (data != null) {
                DataList(data)
            }
        }

        is Resource.Error -> {
            Text(text = (dataState as Resource.Error).message ?: "An error occurred")
        }
    }
}

@Composable
fun DataList(data: List<TramoModel>) {
    LazyColumn {
        items(data) { item ->
//            Text(text = item.toString())
            Text(text = "ID: ${item.uid}, Total: ${item.total}, Status: ${item.statusMoney}, Date: ${item.date}, Threa ${Thread.currentThread().name}")
        }
    }
}

