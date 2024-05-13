package com.example.inventoryapp.ui.theme.Screen.AddProduct

import com.example.inventoryapp.R
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventoryapp.Data.ProductAdd
import com.example.inventoryapp.Data.ProductViewModel
import com.example.inventoryapp.Data.onCancel
import com.example.inventoryapp.Navigation.Routes.ROUTE_POSMasterData


@Composable
fun AddProductScreen(context: NavHostController, navController: Any) {

    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var stock by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var isBottomSheetVisible by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .height(30.dp)
        )

        Image(
            painter = painterResource(id = imageUri?.let { R.drawable.ic_launcher_foreground } ?: R.drawable.masterdata),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(MaterialTheme.shapes.medium)
                .clickable {
                },
            contentScale = ContentScale.Crop
        )
        
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name of Product") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        TextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Selling Price") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        TextField(
            value = stock,
            onValueChange = { stock = it },
            label = { Text("Stock Amount") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )


        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .heightIn(min = 120.dp)
        )


        Button(
            onClick = {
                val productRepository =
                    ProductViewModel(ProductAdd(name, price, stock, description, imageUri))
                navController.navigate(ROUTE_POSMasterData)},

       // { onSave(ProductAdd(name, price, stock, description, imageUri)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Save")
        }

        Button(
            onClick = onCancel,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("cancel")
        }
        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    showDialog = false
                },
                title = {
                    Text("select")
                },
                text = {
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                        }
                    ) {
                        Text("cancel")
                    }
                }
            )
        }
    }
}

fun ProductViewModel(navController: ProductAdd): ProductViewModel {
    TODO("Not yet implemented")
}

private fun Any.navigate(routePosmasterdata: String) {
    TODO("Not yet implemented")
}

fun onSave(productAdd: ProductAdd) {

}

class AddProduct(onSave: NavHostController) : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                AddProduct(rememberNavController())
            }
            TopAppBar(
                title = { Text(text = "AddProduct") },
                //backgroundColor = Color(0xFFD8BFD8), contentColor = Color.White)
            )
        }
    }
}
