package com.faezolmp.tracker_money_app.presentation.component.componentDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faezolmp.tracker_money_app.R
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import com.faezolmp.tracker_money_app.core.utils.FormatMoney

@Composable
fun StruckCard(
    painter: Painter,
    modifier: Modifier = Modifier,
    tramoData: TramoModel,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painter,
                    contentDescription = "Logo Tramo",
                    modifier = Modifier.size(48.dp)
                )
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = tramoData.date.toString(), fontSize = 12.sp, color = Color.Gray
                    )
                    Text(text = "ID TRAMO 0878••••0819", fontSize = 12.sp, color = Color.Gray)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Status transaksi
            Text(
                text = if (tramoData.statusMoney == "in") "Berhasil diterima" else "Transaksi Berhasil",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4CAF50)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = if (tramoData.statusMoney == "in") {
                    "Terima Uang ${FormatMoney.formatCurrency(tramoData.total)} dari ${tramoData.description}"
                } else {
                    "Pembayaran ${FormatMoney.formatCurrency(tramoData.total)} ke ${tramoData.description}"
                },
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                maxLines = 1,
                softWrap = true,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .background(Color(0xFFE0E0E0), RoundedCornerShape(8.dp))
                    .padding(8.dp),
            ) {
                Text(
                    text = if (tramoData.statusMoney == "in") "UANG MASUK" else "UANG KELUAR",
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Total terima
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFBBDEFB), RoundedCornerShape(8.dp))
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total ${if (tramoData.statusMoney == "in") "Terima" else "Bayar"}",
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = FormatMoney.formatCurrency(tramoData.total),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            Divider(
                thickness = 1.5.dp, color = Color.Gray
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Detail Transaksi
            Column {
                Text(
                    text = "Detail Transaksi",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "ID Transaksi",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.weight(2f)
                    )
                    Text(
                        text = "2024100710121420010100166484150986020",
                        textAlign = TextAlign.End,
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier.weight(2f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "ID Order Merchant", fontSize = 14.sp, color = Color.Gray)
                    Text(text = "••• 3233", fontSize = 14.sp, color = Color.Black)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Catatan",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = modifier.weight(1.2f)
                    )
                    Text(
                        text = tramoData.description!!,
                        fontSize = 14.sp,
                        textAlign = TextAlign.End,
                        color = Color.Black,
                        modifier = modifier.weight(2f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Divider(
                thickness = 1.5.dp, color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Footer dengan informasi merchant
            Column {
                Text(text = "*Termasuk PLL(Parkir dll)", fontSize = 12.sp, color = Color.Gray)
                Spacer(modifier = modifier.height(2.dp))
                Text(text = "Noted By Tramo App", fontSize = 12.sp, color = Color.Gray)
                Text(text = "FMP: 6287-8636-2081-9", fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}

@Preview
@Composable
fun PreviewStruckCardOut() {
    StruckCard(
        painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_up_24),
        tramoData = TramoModel(
            uid = 3867,
            total = 5_000_000L,
            statusMoney = "out",
            description = "Gorengan, Cilok, Matabak, Bakso, Mie Ayam, Air Minum Coca Cola, Fanta",
            date = "Thu Oct 10 17:08:44 GMT 2024"
        )

    )
}

@Preview
@Composable
fun PreviewStruckCardIn() {
    StruckCard(
        painter = painterResource(id = R.drawable.baseline_keyboard_double_arrow_down_24),
        tramoData = TramoModel(
            uid = 3867,
            total = 50_000L,
            statusMoney = "in",
            description = "WD Saham",
            date = "2024-10-07 18:37:00"
        )
    )
}
