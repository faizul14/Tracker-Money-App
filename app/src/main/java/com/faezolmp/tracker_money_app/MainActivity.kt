package com.faezolmp.tracker_money_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowInsetsControllerCompat
import androidx.compose.ui.graphics.toArgb
import com.faezolmp.tracker_money_app.presentation.ui.theme.ProjekandroidtemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjekandroidtemplateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    HomeScreen()
                    setStatusBarColor() // Mengatur warna status bar
                    TramoApp()
                }
            }
        }
    }
    private fun setStatusBarColor() {
        // Ubah warna status bar menjadi hitam
        window.statusBarColor = Color.Black.toArgb()
        // Mengatur ikon menjadi terang
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProjekandroidtemplateTheme {
        Greeting("Android")
    }
}