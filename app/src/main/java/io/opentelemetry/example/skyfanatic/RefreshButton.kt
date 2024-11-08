package io.opentelemetry.example.skyfanatic

import android.os.AsyncTask
import android.os.Looper
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val iconFetcher by lazy { IconFetcher() }

@Composable
fun RefreshButton(skyItemState: MutableState<String>){
    Button(
        onClick = {
            Log.d("sky-fanatic", "click")
            iconFetcher.fetch {
                skyItemState.value = it
            }
        },
        modifier = Modifier.padding(20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
        content = {
            Text(text = "refresh", fontSize = 30.sp, color = Color.Red,
                modifier = Modifier.padding(10.dp)
            )
        },
    )
}

