package com.example.inventoryapp.ui.theme.Screen.Transaction

import com.example.inventoryapp.MainActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventoryapp.Navigation.Routes.ROUTE_RECEIPT
import com.example.inventoryapp.R


class Transactionsuccess : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                TransactionSuccessDialog(context = rememberNavController())
            }
        }
    }
}


@Composable
fun TransactionSuccessDialog(context: NavHostController){// = LocalContext.current) {
    var openDialog by remember { mutableStateOf(true) }

    if (openDialog) {
        AlertDialog(
            onDismissRequest = {
                // Handle dismiss request if needed
                openDialog = false
            },
            title = {
                Text(text = "TransactionSuccessful", textAlign = TextAlign.Center)
            },
            text = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.transactionsukses),
                        contentDescription = "Transaction Success Image",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 16.dp)
                    )
                    Text(
                        text = "Thank You For Your Transaction!",
                        textAlign = TextAlign.Center
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        val navController = null
                        navController?.navigate(ROUTE_RECEIPT)

                         },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.medium)
                ) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "PrintReceipt")
                }
            },
            dismissButton = {
                Button(
                    onClick = {

                        // Implement your logic for closing the dialog

                        //val intent = Intent(context, MainActivity::class.java)
                        //context.startActivity(intent)

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.medium)
                ) {
                    Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "close")
                }
            }
        )
    }
}

private fun NavHostController.navigate(routeReceipt: String) {
    TODO("Not yet implemented")
}

@Composable

fun Transactionsuccess(context: NavHostController) {
}