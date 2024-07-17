package com.example.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aluvery.model.ProductModel
import com.example.aluvery.sampledata.sampleProducts
import com.example.aluvery.sampledata.sampleSections
import com.example.aluvery.ui.components.CardProductItem
import com.example.aluvery.ui.components.ProductSection
import com.example.aluvery.ui.components.SearchTextField
import com.example.aluvery.ui.theme.AluveryTheme

@Composable
fun HomeScreen(
    sections: Map<String, List<ProductModel>>,
    searchText: String = ""
) {
    Column {
        var text by remember {
            mutableStateOf(searchText)
        }
        SearchTextField(
            searchText = text,
            onSearchChange = {
                text = it
            },
        )
        val searchProduct = remember(text) {
            sampleProducts.filter { productModel ->
                productModel.name.contains(
                    text,
                    ignoreCase = true
                ) ||
                        productModel.description?.contains(
                            text,
                            ignoreCase = true
                        ) ?: false
            }
        }

        LazyColumn(
            Modifier
                .padding(top = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)

        ) {
            if (text.isBlank()) {
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductSection(title = title, products = products)
                    }
                }
            } else {
                items(searchProduct) { p ->
                    CardProductItem(
                        product = p,
                        Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
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


@Preview(showSystemUi = true)
@Composable
fun HomeScreenWithSearchBarPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(
                sampleSections,
                searchText = "pizza"  //testar filtro
            )
        }
    }
}