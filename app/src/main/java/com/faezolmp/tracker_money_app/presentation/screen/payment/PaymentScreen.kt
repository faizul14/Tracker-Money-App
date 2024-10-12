package com.faezolmp.tracker_money_app.presentation.screen.payment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faezolmp.tracker_money_app.R
import com.faezolmp.tracker_money_app.core.domain.model.TramoModel
import com.faezolmp.tracker_money_app.core.utils.FormatDate
import com.faezolmp.tracker_money_app.core.utils.FormatMoney
import com.faezolmp.tracker_money_app.presentation.component.FilterChipComponent
import com.faezolmp.tracker_money_app.presentation.component.ItemTramoComponent
import com.faezolmp.tracker_money_app.presentation.component.componentPayment.SuccesDialog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.compose.koinViewModel
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentSecren(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    vieModel: PaymentViewModel = koinViewModel()
) {
    val scope = rememberCoroutineScope()
    var totalStateData by rememberSaveable {
        mutableStateOf("")
    }
    var descriptionStateData by rememberSaveable {
        mutableStateOf("")
    }
    var statusStateData by rememberSaveable {
        mutableStateOf("in")
    }

    var isShowDialog by rememberSaveable {
        mutableStateOf(false)
    }

    val checkIsTerisi by remember {
        derivedStateOf {
            totalStateData.isNotEmpty() && descriptionStateData.isNotEmpty()
        }
    }



    Column {
        if (isShowDialog) {
            SuccesDialog(description = descriptionStateData)
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(16.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "arrow Back",
                tint = Color.White,
                modifier = modifier.clickable {
                    navigateToHome()
                })
            Spacer(modifier = modifier.width(8.dp))
            Text(
                text = "Payment",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                maxLines = 1,
                modifier = modifier.fillMaxWidth(7f / 10f)
            )
        }
        Column(
            horizontalAlignment = Alignment.Start, modifier = modifier
//                .fillMaxSize()
//                .background(Color.Gray)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
//            Text(
//                text = "Total Payment"
//            )
//            Spacer(modifier = modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Payment",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier.offset(0.dp, -2.dp)
                )
                Text(
                    text = "IDR",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier.offset(14.dp, -2.dp)
                )
                OutlinedTextField(
                    value = totalStateData,
                    onValueChange = { totalStateData = FormatMoney.formatMoeneybyGroup(it) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    placeholder = {
                        Text(
                            text = "00,00",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black
                        )
                    },
                    textStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent,
                        errorBorderColor = Color.Transparent
                    ),
                    modifier = modifier.fillMaxWidth(),
                )
            }
//            OutlinedTextField(
//                value = totalStateData,
//                onValueChange = { totalStateData = it },
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//                placeholder = {
//                    Text(text = "IDR00,00")
//                },
//                textStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal),
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    unfocusedBorderColor = Color.Transparent,
//                    focusedBorderColor = Color.Transparent,
//                    disabledBorderColor = Color.Transparent,
//                    errorBorderColor = Color.Transparent
//                ),
//                modifier = modifier.fillMaxWidth(),
//            )

            Spacer(modifier = modifier.height(4.dp))

            Text(
                text = "Description"
            )
            Spacer(modifier = modifier.height(8.dp))
            OutlinedTextField(value = descriptionStateData,
                onValueChange = { descriptionStateData = it },
                placeholder = {
                    Text(text = "Desctiption", color = Color.Black)
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    disabledBorderColor = Color.Black,
                    errorBorderColor = Color.Black
                ),
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(4f / 10f)
            )

            Spacer(modifier = modifier.height(16.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChipComponent(
                    selected = statusStateData == "in", label = "in", modifier = modifier
//                        .fillMaxWidth(1f)
//                        .fillMaxWidth(5f/10f)
                ) {
                    statusStateData = "in"
                }
                FilterChipComponent(
                    selected = statusStateData == "out", label = "out", modifier = modifier
//                        .fillMaxWidth(5f/10f)
                ) {
                    statusStateData = "out"
                }
            }

            Spacer(modifier = modifier.height(16.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
//                    .height(100.dp),
//                    .padding(16.dp),
                colors = CardDefaults.cardColors(Color.White),
                shape = RoundedCornerShape(4.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                ItemTramoComponent(
                    tramo = TramoModel(
                        uid = 4954,
                        total = if(totalStateData.isNotEmpty()){
                            FormatMoney.formatClearMoney(totalStateData)
                        }else{
                            0L
                        },
                        statusMoney = statusStateData,
                        description = if(descriptionStateData.isNotEmpty()) descriptionStateData else "Payment Description",
                        date = FormatDate.formatInputDate(Date())
                    )
                ) { }
            }

        }
        Box(
            modifier = modifier
                .fillMaxSize()
//                .background(Color.Gray)
                .padding(16.dp)
        ) {
            OutlinedButton(
                enabled = checkIsTerisi, onClick = {
                    vieModel.insertData(
                        total = FormatMoney.formatClearMoney(totalStateData).toString(),
                        description = descriptionStateData,
                        status = statusStateData
                    )
                    isShowDialog = !isShowDialog
                    scope.launch {
                        delay(1_000)
                        isShowDialog = !isShowDialog
                        withContext(Dispatchers.Main) {
                            navigateToHome()
                        }
                    }
//                    navigateToHome()
                },
                border = BorderStroke(1.dp, Color.Black), // Mengatur outline hitam
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black // Mengatur warna teks button

                ),
                modifier = modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
            ) {
                Text(text = "Pay Now")
            }
        }
    }


}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun PaymentSecrenPreview() {
    PaymentSecren(navigateToHome = {})
}