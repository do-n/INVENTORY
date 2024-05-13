package com.example.inventoryappp.ui.theme.Screen.Receipt


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import java.text.SimpleDateFormat
import java.util.*

class Receipt(navController: NavHostController) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                ReceiptScreen(rememberNavController())
            }
        }
    }
}

@Composable
fun ReceiptScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Receipt",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge
        )
        DashedDivider()

        Text("Name", fontWeight = FontWeight.Bold)
        Text("Marocho Limited")

        DashedDivider()

        Text("DAY: ${getCurrentDateTime()}")
        Text("ORDER: 123456")

        Spacer(modifier = Modifier.height(16.dp))

        Text("Customer Nme: John Doe", fontWeight = FontWeight.Bold)

        DashedDivider()

        Spacer(modifier = Modifier.height(8.dp))

        Text("ITEM:")

        Spacer(modifier = Modifier.height(8.dp))

        ProductItem("Product 1", 2, 10.0)
        ProductItem("Product 2", 1, 20.0)

        DashedDivider()

        Spacer(modifier = Modifier.height(8.dp))

        Text("Total Item: 3")
        Text("Total :30.00", fontWeight = FontWeight.Bold)

        DashedDivider()

        Text("plastic: 50")
        Text("stick: 20")

        DashedDivider()

        Text("       Thank you ")

        Spacer(modifier = Modifier.height(16.dp))

        DashedDivider()

        Text("Powered by Marocho", fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Icon(
            //imageVector = Icons.Default.Print,
            //contentDescription = "Print",
            //modifier = Modifier.size(32.dp)
            //)
            Spacer(modifier = Modifier.width(16.dp))
            //Icon(
            //imageVector = Icons.Default.Download,
            //contentDescription = "Download",
            //modifier = Modifier.size(32.dp)
            //)
        }
    }
}

@Composable
fun ProductItem(name: String, quantity: Int, price: Double) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        ) {
            Text(text = name)
            Text(text = "Quantity: $quantity")
            Text(text = "Price: ${price * quantity}")
        }
    }
}

fun getCurrentDateTime(): String {
    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    return sdf.format(Date())
}

@Composable
fun DashedDivider() {
    Spacer(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .height(2.dp)
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(MaterialTheme.shapes.small)
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewReceiptScreen() {
    ReceiptScreen(rememberNavController())
}