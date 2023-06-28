package com.example.myapplication.ui.components.bodyrows

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.myscreen.model.PaymentMethodInfoModel

@Composable
fun PaymentMethodInfo(
    paymentMethodInfoModel: PaymentMethodInfoModel,
    modifier: Modifier = Modifier
) {
    Text(
        text = paymentMethodInfoModel.methodType,
        modifier = Modifier.padding(start = 16.dp, top = 16.dp),
        color = Color.Black.copy(alpha = 0.9f),
        textAlign = TextAlign.Center
    )
}
