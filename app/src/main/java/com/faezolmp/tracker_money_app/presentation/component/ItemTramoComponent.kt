package com.faezolmp.tracker_money_app.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faezolmp.tracker_money_app.R
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import com.faezolmp.tracker_money_app.core.utils.DataDummy
import com.faezolmp.tracker_money_app.core.utils.FormatDate
import com.faezolmp.tracker_money_app.core.utils.FormatMoney.formatCurrency
import java.text.NumberFormat
import java.util.Currency

@Composable
fun ItemTramoComponent(
    modifier: Modifier = Modifier,
    tramo: TramoModel,
    navigationToDetail: (TramoModel) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(Color.Transparent),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp, 4.dp)
            .clickable { navigationToDetail(tramo) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 2.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
//                    text = FormatDate.formatByFmpStyle(tramo.date.toString()) ?: "N/A",
                    text = tramo.date.toString() ?: "N/A",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    maxLines = 1,
                    softWrap = false,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier.fillMaxWidth()
                )
                Text(
                    text = "Ket. ${if(tramo.statusMoney == "in") "Get" else "Pay"} ${tramo.description ?: "N/A"}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    maxLines = 1,
                    softWrap = false,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier.fillMaxWidth(7f/10f)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = tramo.statusMoney ?: "N/A",
                        style = MaterialTheme.typography.bodyMedium,
                        color = if(tramo.statusMoney == "in") Color.Green else Color.Red,
                        modifier = modifier
                            .fillMaxWidth(1f/10f)
                    )
                    Icon(
                        painterResource(id = if(tramo.statusMoney == "in") R.drawable.baseline_keyboard_double_arrow_down_24 else R.drawable.baseline_keyboard_double_arrow_up_24),
                        contentDescription = tramo.statusMoney,
                        tint = if (tramo.statusMoney == "in") Color.Green else Color.Red
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = formatCurrency(tramo.total),
                    style = MaterialTheme.typography.bodySmall,
                    color = if(tramo.statusMoney == "in") Color.Green else Color.Red

                )
            }
        }
    }
}



@Composable
fun DataList(data: List<TramoModel>) {
    LazyColumn {
        items(data) { item ->
//            Text(text = item.toString())
            ItemTramoComponent(tramo = item, navigationToDetail = {})
        }
    }
}

@Preview(
    showSystemUi = true,
//    device = Devices.PIXEL_3A_XL
)
@Composable
fun ItemTramoComponentPreview() {
//    ItemTramoComponent(
//        tramo = TramoModel(
//            uid = 0,
//            total = 1_000_990L,
//            statusMoney = "in",
//            date = Date().toString()
//        )
//    )
    DataList(data = DataDummy.dataDummy2())
}