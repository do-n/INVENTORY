package com.example.inventoryapp.ui.theme.Screen.Report


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

class Report : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            POSReport()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun POSReport(){
    Column {
        TopAppBar(title = { Text(text = "Report") })
    }
}