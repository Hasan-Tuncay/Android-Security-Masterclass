package com.hasantuncay.mobsec

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hasantuncay.mobsec.ui.theme.AndroidSecurityMasterclassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // MASWE-0001: Zafiyetli Loglama (Vulnerable Logging)
        // Hassas veriler (parola, token vb.) loglara açıkça yazılıyor.
        val userPassword = "SuperSecretPassword123!"
        Log.d("MASWE-0001", "Kullanıcı giriş yaptı. Şifre: $userPassword")
        
        enableEdgeToEdge()
        setContent {
            AndroidSecurityMasterclassTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
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
    AndroidSecurityMasterclassTheme {
        Greeting("Android")
    }
}