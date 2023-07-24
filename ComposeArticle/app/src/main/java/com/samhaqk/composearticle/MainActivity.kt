package com.samhaqk.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samhaqk.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BgImg(
                        heading = stringResource(R.string.heading),
                        short_para = stringResource(R.string.para1),
                        long_para = stringResource(R.string.para2)
                    )
                }
            }
        }
    }
}

@Composable
fun BgImg(heading: String, short_para: String, long_para: String) {
    val bg = painterResource(id = R.drawable.bgmain)
    Box {
        Image(
            painter = bg,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Article(heading = heading, short_para = short_para, long_para = long_para)

    }
}

@Composable
fun Article(heading: String, short_para: String, long_para: String) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null
        )
        Surface(
            color = Color.Black.copy(alpha = 0.3f),
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                Text(
                    text = heading,
                    color = Color.White,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(16.dp)
                )
                Text(
                    text = short_para,
                    color = Color.White,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                )
                Text(
                    text = long_para,
                    color = Color.White,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        Article(
            heading = stringResource(R.string.heading),
            short_para = stringResource(R.string.para1),
            long_para = stringResource(R.string.para2)
        )
    }
}