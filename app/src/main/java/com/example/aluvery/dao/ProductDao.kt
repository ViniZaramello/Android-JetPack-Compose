package com.example.aluvery.dao

import androidx.compose.runtime.mutableStateListOf
import com.example.aluvery.model.ProductModel
import com.example.aluvery.sampledata.sampleProducts

class ProductDao {

    companion object {
        private val products =  mutableStateListOf<ProductModel>(*sampleProducts.toTypedArray())
    }

    fun products() = products.toList()
    fun save(product: ProductModel) {
        products.add(product)
    }
}