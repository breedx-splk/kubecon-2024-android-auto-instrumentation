package io.opentelemetry.example.skyfanatic

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.opentelemetry.example.skyfanatic.ui.theme.SkyFanaticTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SkyFanaticTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainLayout(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun MainLayout(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxHeight()
    ) {
        Row(
            Modifier.padding(all = 20.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "\uD83D\uDD2D",
                fontSize = 200.sp,
                textAlign = TextAlign.Center,
                modifier = modifier
            )
        }
        Row(
            Modifier.padding(all = 20.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "SkyFanatic",
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                modifier = modifier
            )
        }
        Row(
            Modifier.padding(all = 20.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = { Log.d("sky-fanatic", "click") },
                modifier = Modifier.padding(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                content = {
                    Text(text = "refresh", fontSize = 30.sp, color = Color.Red,
                        modifier = Modifier.padding(10.dp)
                    )
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SkyFanaticTheme {
        MainLayout()
    }
}