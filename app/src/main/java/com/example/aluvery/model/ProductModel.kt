package com.example.aluvery.model

import java.math.BigDecimal

class ProductModel(
    val name: String,
    val value: BigDecimal,
    val image: String? = null,
    val description: String? = null
)
