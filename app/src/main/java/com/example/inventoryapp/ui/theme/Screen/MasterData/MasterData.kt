package com.example.inventoryapp.ui.theme.Screen.MasterData

import androidx.compose.material3.TopAppBar
import com.example.inventoryapp.R
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.text.AnnotatedString
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventoryapp.Data.intentPrintreceipt.putExtra
import com.example.inventoryapp.Navigation.Routes.ROUTE_AddProduct

import com.example.inventoryapp.ui.theme.Screen.AddProduct.AddProduct
import com.example.inventoryapp.ui.theme.Screen.POSTransaction.ProductTransaction
import com.example.inventoryapp.ui.theme.Screen.Transaction.Transactionsuccess
import com.example.inventoryapp.ui.theme.Screen.detailproduct.DetailProduct


private var Any.flags: Int
    get() {
        TODO("Not yet implemented")
    }
    set(value) {}

data class Product(val id: Int, val name: String, val price: Double, val imageResId: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun POSMasterData(context: NavHostController) {
    Column {
        TopAppBar(title = {Text(text = "Master Data")},
            //contentColor = MaterialTheme.colorScheme.primary)
        )}

    val products = listOf(
        ProductTransaction(1, "Rice", 350.00, R.drawable.beras),
        ProductTransaction(2, "Eggs", 270.00, R.drawable.telur),
        ProductTransaction(3, "Chilli", 75.00, R.drawable.cabai),
        ProductTransaction(4, "Tomato", 150.00, R.drawable.tomato),
        ProductTransaction(5, "Red onion", 50.00, R.drawable.onion),
        ProductTransaction(6, "onion", 70.00, R.drawable.bawang),
        ProductTransaction(7, "Onions", 170.00, R.drawable.daunbawang),
        ProductTransaction(8, "Pumpkin", 350.00, R.drawable.labu),
        ProductTransaction(9, "Ginger", 30.00, R.drawable.jahe),
        ProductTransaction(10, "Pala", 150.00, R.drawable.pala),
        ProductTransaction(11, "Vanilla", 100.00, R.drawable.vanilla),
    )
    var searchQuery by remember { mutableStateOf("") }
    Column {
        TopAppBar(
            title = { Text(text = "STORE") },
           // backgroundColor = Color(0xFFD8BFD8),
            //ontentColor = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Kotak pencarian
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            label = { Text("Search") },
            placeholder = { Text("Search For Products...") },
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
            modifier = Modifier.fillMaxWidth()
        ) {
            items(
                count = products.filter {
                    it.name.contains(searchQuery, ignoreCase = true)
                }.size
            ) { index ->
                val product = products.filter {
                    it.name.contains(searchQuery, ignoreCase = true)
                }[index]

                ProductListItem(product = product) { selectedProduct ->
                    //val intent = Intent(context, DetailProduct::class.java)
                    (Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK).also {flags = it }
                    putExtra("productId", selectedProduct.id)
                    putExtra("productName", selectedProduct.name)
                    putExtra("productPrice", selectedProduct.price)
                    putExtra("productImageResId", selectedProduct.imageResId)
                   // context.startActivity(intent)
                }
            }
        }
    }
}
@Composable
fun ProductListItem(product: ProductTransaction, onItemClick: (Product) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier.clickable {
                onItemClick(product)
            }
        ) {
            Image(
                painter = painterResource(id = product.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(shape = RoundedCornerShape(4.dp))
            )}
        Spacer(modifier = Modifier.width(24.dp))
        Row {
            ClickableText(
                text = AnnotatedString(product.name),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f),
                onClick = {
                    onItemClick(product)
                })
            ClickableText(
                text = AnnotatedString(product.price.tonumberFormat()),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(end = 24.dp),
                onClick = {
                    onItemClick(product)
                })
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

fun onItemClick(product: ProductTransaction) {

}

fun Double.tonumberFormat(): String {
    val formattedValue = java.text.NumberFormat.getCurrencyInstance(java.util.Locale("ksh", "ksh"))
        .format(this)
    return formattedValue.replace("IDR", "Ksh")
}

private fun Any?.navigate(routeAddproduct: String) {
    TODO("Not yet implemented")
}

@Composable
fun MasterDataScreen(navController: Any?) {
    val context = LocalContext.current
    val intentAddProduct= Intent(context, AddProduct::class.java)

    var isAddingProduct by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        FloatingActionButton(
            onClick ={
                navController.navigate(ROUTE_AddProduct)
            },
            modifier = Modifier
                .padding(16.dp)
                .padding(end = 30.dp)
                .padding(bottom = 20.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Product",
                modifier = Modifier.size(24.dp)
            )

        }
    }
}



class MasterData : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            POSMasterData(rememberNavController())
            MasterDataScreen(navController = null)
        }
    }
}