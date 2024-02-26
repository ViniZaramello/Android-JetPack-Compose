package com.example.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aluvery.ui.components.ProductSection

@Composable
fun HomeScreen(){
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier)
        ProductSection("Promoções")
        ProductSection("Doces")
        ProductSection("Bebidas")
        Spacer(modifier = Modifier)
    }

}
@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}