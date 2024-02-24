package com.example.aluvery.model

import androidx.annotation.DrawableRes
import java.math.BigDecimal

class ProductModel(
    val name: String,
    val value: BigDecimal,
    @DrawableRes val image: Int
)
