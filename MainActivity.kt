package com.example.dessertclicker

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dessertclicker.ui.theme.DessertClickerTheme

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {

    // Métodos del ciclo de vida con logs para seguimiento en Logcat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate Called")
        setContent {
            DessertClickerTheme {
                Surface(color = MaterialTheme.colors.background) {
                    DessertClickerApp()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }
}

@Composable
fun DessertClickerApp() {
    var dessertsSold by remember { mutableStateOf(0) }
    var totalRevenue by remember { mutableStateOf(0) }
    val dessertPrice = 5
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.cupcake),
            contentDescription = "Dessert",
            modifier = Modifier
                .size(200.dp)
                .clickable {
                    dessertsSold++
                    totalRevenue += dessertPrice
                    // Mostrar un Toast como feedback visual
                    Toast.makeText(context, "¡Postre comprado!", Toast.LENGTH_SHORT).show()
                }
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Postres vendidos: $dessertsSold")
        Text(text = "Ingresos totales: $$totalRevenue")
    }
}
