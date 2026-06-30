package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var valueNumber by remember { mutableIntStateOf(1) }

    val image = when(valueNumber) {
        1 -> R.drawable.pexels_01
        2 -> R.drawable.pexels_02
        3 -> R.drawable.pexels_03
        4 -> R.drawable.pexels_04
        5 -> R.drawable.pexels_05
        6 -> R.drawable.pexels_06
        else -> R.drawable.pexels_07
    }

    val artworkTitle = when(valueNumber) {
        1 -> R.string.design_title01
        2 -> R.string.design_title02
        3 -> R.string.design_title03
        4 -> R.string.design_title04
        5 -> R.string.design_title05
        6 -> R.string.design_title06
        else -> R.string.design_title07
    }

    val artworkArtist = when(valueNumber) {
        1 -> R.string.artist_name01
        2 -> R.string.artist_name02
        3 -> R.string.artist_name03
        4 -> R.string.artist_name04
        5 -> R.string.artist_name05
        6 -> R.string.artist_name06
        else -> R.string.artist_name07
    }

    val yearArtist = when(valueNumber) {
        1 -> R.string.year01
        2 -> R.string.year02
        3 -> R.string.year03
        4 -> R.string.year04
        5 -> R.string.year05
        6 -> R.string.year06
        else -> R.string.year07
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
    ) {
        Surface(
            modifier = Modifier
                .size(350.dp)
                .shadow(
                    elevation = 16.dp,
                    shape = RoundedCornerShape(16.dp)
                ),
            color = Color.White
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(32.dp)
            )
        }

        Spacer(modifier = Modifier.height(55.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .background(
                    Color(0xFFECEFF1),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(artworkTitle),
                fontSize = 24.sp,
                fontWeight = FontWeight.Light
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(stringResource(artworkArtist ) + " ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Gray,
                            fontWeight = FontWeight.Light
                        )
                    ) {
                        append("("+stringResource(yearArtist)+")")
                    }
                },
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$valueNumber of 7"
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ButtonItem(
                text = R.string.previous_btn_text,
                onClick = {
                    if (valueNumber > 1) {
                        valueNumber--
                    } else {
                        valueNumber = 7
                    }
                }
            )
            ButtonItem(
                text = R.string.next_btn_text,
                onClick = {
                    if (valueNumber < 7) {
                        valueNumber++
                    } else {
                        valueNumber = 1
                    }
                }
            )
        }
    }
}

@Composable
fun ButtonItem(
    @StringRes text: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text = stringResource(text)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}