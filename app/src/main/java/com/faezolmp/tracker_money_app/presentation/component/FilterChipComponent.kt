package com.faezolmp.tracker_money_app.presentation.component

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipComponent(
    selected: Boolean,
    label: String,
    modifier: Modifier = Modifier,
    onSelected: (Boolean) -> Unit,
) {
//    var selected by rememberSaveable {
//        mutableStateOf(isSelected)
//    }

    FilterChip(
        selected = selected,
        onClick = {
//            selected = !selected
            onSelected(!selected)
        },
        label = {
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "#$label",
                    color = if(selected) Color.White else Color.Black,
                    modifier = modifier.offset(-5.dp, 0.dp)
                )
            }
        },
//        colors = ChipDefaults.filterChipColors(
//            backgroundColor = if (selected) Color.Blue else Color.Gray,
//            contentColor = if (selected) Color.White else Color.Black
//        ),
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = if (selected) Color.Black else Color.White,
//            labelColor = if (selected) Color.White else Color.Black
        ),
        modifier = modifier
            .width(100.dp)
//            .fillMaxWidth(3f/10f)
//        leadingIcon = if (selected) {
//            {
//                Icon(
//                    imageVector = Icons.Filled.Done,
//                    contentDescription = "Done icon",
//                    modifier = Modifier.size(FilterChipDefaults.IconSize)
//                )
//            }
//        } else {
//            null
//        },
    )
}

@Preview()
@Composable
fun FilterChipComponentPreview() {
//    FilterChipComponent(
//        sendDataFilter = {
//
//        }
//    )
    FilterChipComponent(selected = false, label = "All", onSelected ={} )
}