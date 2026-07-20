package com.hasantuncay.mobsec.secure

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
import com.hasantuncay.mobsec.secure.ui.theme.AndroidSecurityMasterclassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // MASWE-0001: Güvenli Loglama (Secure Logging)
        // Hassas veriler (parola, token vb.) loglara kesinlikle yazılmaz.
        val userId = "user_789456"
        Log.d("MASWE-0001", "Kullanıcı giriş yaptı. Kullanıcı ID: $userId")
        
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