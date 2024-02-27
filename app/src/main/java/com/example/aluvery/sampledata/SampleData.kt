package com.example.aluvery.sampledata

import com.example.aluvery.R
import com.example.aluvery.model.ProductModel
import java.math.BigDecimal


val sampleProducts = listOf(
    ProductModel(
        name = "meia Tietê com borda brumadinho",
        value = BigDecimal("39.99"),
        image = R.drawable.pizza
    ),
    ProductModel(
        name = "x-ratão",
        value = BigDecimal("10.99"),
        image = R.drawable.burger
    ),
    ProductModel(
        name = "porção batata 200gr",
        value = BigDecimal("5.90"),
        image = R.drawable.fries
    )
)