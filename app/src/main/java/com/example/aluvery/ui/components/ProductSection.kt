package com.example.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aluvery.R
import com.example.aluvery.model.ProductModel
import java.math.BigDecimal

@Composable
fun ProductSection(topic: String) {
    Column {
        Text(
            text = topic,
            Modifier.padding(
                start = 16.dp
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .padding(
                    top = 8.dp
                )
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier)
            ProductItem(
                ProductModel(
                    name = "meia Tietê com borda brumadinho",
                    value = BigDecimal("39.99"),
                    image = R.drawable.pizza
                )
            )
            ProductItem(
                ProductModel(
                    name = "x-ratão",
                    value = BigDecimal("10.99"),
                    image = R.drawable.burger
                )
            )
            ProductItem(
                ProductModel(
                    name = "porção batata 200gr",
                    value = BigDecimal("5.90"),
                    image = R.drawable.fries
                )
            )
            Spacer(Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductSectionPreview() {
    ProductSection("Promoções")
}
