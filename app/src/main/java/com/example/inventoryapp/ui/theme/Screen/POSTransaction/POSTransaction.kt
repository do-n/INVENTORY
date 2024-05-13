package com.example.inventoryapp.ui.theme.Screen.POSTransaction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventoryapp.R
import com.example.inventoryapp.Data.Product
import com.example.inventoryapp.Data.intentPrintreceipt.putExtra
import com.example.inventoryapp.Navigation.Routes.ROUTE_TRANSACTION
import com.example.inventoryapp.ui.theme.Screen.MasterData.tonumberFormat
import com.example.inventoryapp.ui.theme.Screen.Transaction.Transactionsuccess


val totalitems: String = ""

data class ProductTransaction(val id: Int, val name: String, val price: Double, val imageResId: Int)
data class CartItem(val product: Product, var quantity: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun POSTransaction(context: NavHostController) {
    var totalItems by remember { mutableStateOf(0) }
    var totalPrice by remember { mutableStateOf(0.0) }

    Column {
        TopAppBar(title = { Text(text = "Transaction") },
        )}
           // contentColor = MaterialTheme.colorScheme.primary)

    val productTrans = listOf(
        ProductTransaction(1, "Rice", 35000.00, R.drawable.beras),
        ProductTransaction(2, "Eggs", 27000.00, R.drawable.telur),
        ProductTransaction(3, "Chilli", 75000.00, R.drawable.cabai),
        ProductTransaction(4, "Tomato", 15000.00, R.drawable.tomato),
        ProductTransaction(5, "Red onion", 25000.00, R.drawable.onion),
        ProductTransaction(6, "onion", 27000.00, R.drawable.bawang),
        ProductTransaction(7, "Onions", 17000.00, R.drawable.daunbawang),
        ProductTransaction(8, "Pumpkin", 35000.00, R.drawable.labu),
        ProductTransaction(9, "Ginger", 30000.00, R.drawable.jahe),
        ProductTransaction(10, "Pala", 50000.00, R.drawable.pala),
        ProductTransaction(11, "Vanilla", 1000000.00, R.drawable.vanilla),
    )

    val addToCart: (Double, Int) -> Unit = { price, qty ->
        totalItems =+ qty
        totalPrice =+ price
    }

    var searchQuery by remember { mutableStateOf("") }
    Column {
        TopAppBar(
            title = { Text(text = "Products") },
          //  BackgroundColor = Color(0xFFD8BFD8),
            //ContentColor = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Kotak pencarian
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            label = { Text("") },
            placeholder = { Text("searchforproducts...") },
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = Color.Gray
                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.weight(1f)

        ) {
            items(
                count = productTrans.filter {
                    it.name.contains(searchQuery, ignoreCase = true)
                }.size
            ) { index ->
                val product = productTrans.filter {
                    it.name.contains(searchQuery, ignoreCase = true)
                }[index]

                ProductListItem(product = product) { quantity ->

                    addToCart(product.price * quantity, quantity)
                }


            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable { /* Action when clicked */ }
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "items:${totalitems}",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = totalPrice.tonumberFormat(),
                        fontSize = 18.sp
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = {
                            NavController.navigate(ROUTE_TRANSACTION)
                            putExtra("TOTAL_ITEMS", totalItems.toDouble())
                            .putExtra("Amount", totalPrice)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
                    )
                    {
                        Text(text = "Order")
                    }
                }
            }

        }
    }
}

private fun Any.navigate(routeTransaction: String) {
    TODO("Not yet implemented")
}

private fun Int.tonumberFormat(): Any {
    TODO("Not yet implemented")
}

@Composable
fun ProductListItem(product: ProductTransaction, onQuantityChange: (Int) -> Unit) {
    var numberofproducts by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.clickable {
                //onItemClick(product)
            }
        ) {
            Image(
                painter = painterResource(id = product.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(shape = RoundedCornerShape(4.dp))
            )
        }
        Spacer(modifier = Modifier.width(24.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = product.name,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.price.toRupiahFormats(),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    if (numberofproducts > 0) {
                        numberofproducts--
                        onQuantityChange(numberofproducts)

                    }
                },
                modifier = Modifier.wrapContentSize(),
                colors = ButtonDefaults.buttonColors(Color.LightGray),
            ) {
                Text("-")
            }
            Text(
                text = numberofproducts.toString(),
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            Button(
                onClick = { numberofproducts++
                    onQuantityChange(numberofproducts)
                },
                modifier = Modifier.wrapContentSize(),
            ) {
                Text("+")
            }
        }
    }
}



fun Double.toRupiahFormats(): String {
    val formattedValue = java.text.NumberFormat.getCurrencyInstance(java.util.Locale("", "ke"))
        .format(this)
    return formattedValue.replace("IDR", "ksh. ")
}

class PosTransaction : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            POSTransaction(rememberNavController())
        }
    }
}