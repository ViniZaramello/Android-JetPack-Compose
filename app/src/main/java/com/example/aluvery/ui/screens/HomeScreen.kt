package com.example.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aluvery.model.ProductModel
import com.example.aluvery.sampledata.sampleProducts
import com.example.aluvery.sampledata.sampleSections
import com.example.aluvery.ui.components.ProductSection
import com.example.aluvery.ui.theme.AluveryTheme

@Composable
fun HomeScreen(
    sections: Map<String, List<ProductModel>>
) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier)
        for (section in sections) {
            val title = section.key
            val products = section.value
            ProductSection(title = title, products = products)
        }
        Spacer(modifier = Modifier)
    }

}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}