package com.faezolmp.tracker_money_app.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    FilterChip(selected = selected, onClick = {
        onSelected(!selected)
    }, label = {
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "#$label",
                color = if (selected) Color.White else Color.Black,
                modifier = modifier.offset((-5).dp, 0.dp)
            )
        }
    }, colors = FilterChipDefaults.filterChipColors(
        selectedContainerColor = if (selected) Color.Black else Color.White,
    ), modifier = modifier.width(100.dp)
    )
}

@Preview
@Composable
fun FilterChipComponentPreview() {
    FilterChipComponent(selected = false, label = "All", onSelected = {})
}