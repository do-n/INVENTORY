package com.example.inventoryapp.ui.theme.Screen.detailproduct

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.inventoryapp.R
import com.example.inventoryapp.ui.theme.Screen.MasterData.tonumberFormat

data class ProductDetail(
    val name: String,
    val price: String,
    val description: String,
    val imageUri: String
)
class DetailProduct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetailProduct()
            val productId = intent.getIntExtra("productId", 0)
            val productName = intent.getStringExtra("productName")
            val productPrice = intent.getDoubleExtra("productPrice", 0.0)
            val productImageResId = intent.getIntExtra("productImageResId", 0)
            val productDetail = ProductDetail(
                name = productName ?: "",
                price = productPrice.tonumberFormat(),
                description = ".",
                imageUri = "content://com.deaenita.posfinalproject/${productImageResId}",
            )
            DetailProductContent(productDetail = productDetail)
        }
    
    }
}

@Composable
fun DetailProductContent(productDetail: ProductDetail) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Gambar produk
        Spacer(modifier = Modifier.height(70.dp))

        Image(
            painter = painterResource(R.drawable.sembako),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(
            text = productDetail.name,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "${productDetail.price}",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(
            text = productDetail.description,
            style = MaterialTheme.typography.titleLarge.copy(fontStyle = FontStyle.Italic)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetail(){
    Column {
        TopAppBar(
            title = { Text(text = "Products Details") },
           // backgroundColor = Color(0xFFD8BFD8),
            //contentColor = Color.White
        )
    }
}