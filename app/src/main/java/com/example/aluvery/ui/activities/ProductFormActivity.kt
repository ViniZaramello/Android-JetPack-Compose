package com.example.aluvery.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.aluvery.R
import com.example.aluvery.dao.ProductDao
import com.example.aluvery.model.ProductModel
import com.example.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal


class ProductFormActivity : ComponentActivity() {

    private val dao = ProductDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                ProductFormScreen(onSaveClick = { product ->
                    dao.save(product)
                    finish()
                })
            }
        }
    }
}

@Composable
fun ProductFormScreen(onSaveClick: (ProductModel) -> Unit = {}) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier)
        Text(text = "Criando o produto", Modifier.fillMaxWidth(), fontSize = 28.sp)

        var url by remember {
            mutableStateOf("")
        }
        if (url.isNotBlank()) {
            AsyncImage(
                model = url, contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder)
            )
        }
        TextField(value = url, onValueChange = {
            url = it
        }, Modifier.fillMaxWidth(), label = {
            Text(text = "Url da imagem")
        },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            )
        )

        var name by remember {
            mutableStateOf("")
        }
        TextField(value = name, onValueChange = {
            name = it
        }, Modifier.fillMaxWidth(), label = {
            Text(text = "Nome do produto")
        },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Sentences
            )
        )

        var price by remember {
            mutableStateOf("")
        }
        val priceFormatter = VisualTransformation { textInputValue ->
            val rawString = textInputValue.text
            val formattedString = rawString.replace(Regex("[^\\d]"), "")
                .replace(Regex("(\\d{1,2})(\\d{2})$"), "$1,$2")
                .replace(Regex("(\\d+)(\\d{3})(\\d{2})$"), "$1.$2,$3")
            val annotatedString = AnnotatedString(formattedString)
            TransformedText(annotatedString, OffsetMapping.Identity)
        }
        TextField(
            value = price, onValueChange = { it: String ->
                price = it
            },
            Modifier.fillMaxWidth(), label = {
                Text(text = "Preço")
            },
            visualTransformation = priceFormatter,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )

        var description by remember {
            mutableStateOf("")
        }
        TextField(
            value = description, onValueChange = {
                description = it
            },
            Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            label = {
                Text(text = "Descrição")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )

        Button(
            onClick = {
                val validatePrice = try {
                    BigDecimal(price)
                } catch (e: NumberFormatException) {
                    BigDecimal.ZERO
                }
                val product = ProductModel(
                    name = name,
                    image = url,
                    value = validatePrice,
                    description = description
                )
                Log.i("ProductFormActivity", "$product")
                onSaveClick(product)
            }, Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(text = "teste")
        }
        Spacer(modifier = Modifier)
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProductFormScreenPreview() {
    AluveryTheme {
        Surface {
            ProductFormScreen()
        }
    }
}