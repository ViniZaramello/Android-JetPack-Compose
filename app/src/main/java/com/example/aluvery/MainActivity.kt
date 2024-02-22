package com.example.aluvery

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    MyFirstComposable()
                }
            }
        }
    }
}

@Composable
fun MyFirstComposable() {
    Text(text = "My first composable")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ColumnPreview() {
    Column(
        Modifier
            .padding(8.dp)
            .background(Color.Green)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(text = "texto 1")
        Text(text = "texto 2")
    }

    Row(
        Modifier
            .padding(8.dp)
            .background(Color.Blue)
            .fillMaxWidth(0.9f)

    ) {
        Text(text = "ast")
        Text(text = "asd")

        Column(
            Modifier
                .padding(8.dp)
                .background(Color.Yellow)
        ) {
            Text(text = "abc")
            Text(text = "abc")

        }
    }


}

@Preview(showBackground = true)
@Composable
fun RowPreview() {
    Row {
        Text(text = "abc")
        Text(text = "abc")
    }
}


@Preview(
    name = "UIpreview",
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(name = "OnlyText")
@Preview(
    name = "preview1",
    heightDp = 200,
    widthDp = 300,
    showBackground = true
)
@Composable
fun MyFirstComposablePreview() {
    AluveryTheme {
        Surface {
            MyFirstComposable()
        }
    }
}