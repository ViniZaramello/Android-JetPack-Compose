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

class HomeScreenUiState(searchText: String = "") {

    var text by mutableStateOf(searchText)

    val searchedProduct
        get() =
            if (text.isNotBlank()) {
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
            } else emptyList()

    fun isShowSections(): Boolean {
        return text.isBlank()
    }

    val onSearchChange: (String) -> Unit = {
        text = searchText
    }
}

@Composable
fun HomeScreen(
    sections: Map<String, List<ProductModel>>,
    state: HomeScreenUiState = HomeScreenUiState()
) {
    Column {
        val text = state.text
        val searchProduct = remember(text) {
            state.searchedProduct
        }
        SearchTextField(
            searchText = text,
            onSearchChange = state.onSearchChange
        )
        LazyColumn(
            Modifier
                .padding(top = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)

        ) {
            if (state.isShowSections()) {
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
                state = HomeScreenUiState(searchText = "a")  //testar filtro
            )
        }
    }
}