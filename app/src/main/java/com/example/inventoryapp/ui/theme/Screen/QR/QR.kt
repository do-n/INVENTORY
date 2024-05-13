@file:Suppress("UNREACHABLE_CODE", "ALWAYS_NULL")

package com.example.myapplication.ui.theme.Screen.QR


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventoryapp.Navigation.Routes.ROUTE_HOMEPAGE
import com.example.inventoryapp.R


class Qr(navController: NavHostController) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QrContent(rememberNavController(),)
        }
    }
}

@Composable
fun QrContent(context: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Marocho",
            fontSize = 24.sp, letterSpacing = 10.sp,modifier = Modifier.padding(8.dp))
        Image(
            painter = painterResource(id = R.drawable.kasirpraktis),
            contentDescription = "Transaction Success Image",
        )
        TextButton(
            onClick = {
                val navController = null
                navController.navigate(ROUTE_HOMEPAGE)
            },
            modifier = Modifier
            .wrapContentSize()
            .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.textButtonColors(Color.Black)
        ) {
            Text(
            text = "CLOSE",
            color = Color.White
            )
        }
    }
}

private fun Nothing?.navigate(routeHomepage: String) {


}

