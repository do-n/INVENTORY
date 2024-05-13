package com.example.inventoryapp

import android.os.Build
import android.view.SurfaceControl
import androidx.annotation.RequiresApi
import androidx.compose.material3.Card
import androidx.compose.material3.TopAppBar
import java.util.Locale
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventoryapp.Navigation.Routes.ROUTE_AddProduct
import com.example.inventoryapp.navigation.AppNavHost.AppNavHost
import com.example.inventoryapp.ui.theme.InventoryAppTheme
import com.example.inventoryapp.Navigation.Routes.ROUTE_POSMasterData
import com.example.inventoryapp.Navigation.Routes.ROUTE_POSTransaction
import com.example.inventoryapp.Navigation.Routes.ROUTE_QR
import com.example.inventoryapp.Navigation.Routes.ROUTE_RECEIPT
import com.example.inventoryapp.Navigation.Routes.ROUTE_TRANSACTION
import com.example.inventoryapp.navigation.AppNavHost.AppNavHost
import com.example.inventoryapp.ui.theme.Screen.MasterData.MasterData



class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            InventoryAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    AppNavHost()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun HomePage(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "MAROCHO.LIMITED",
                    letterSpacing = 0.sp, fontSize = 28.sp
                )
            },
           // BackgroundColor = Color(0xFFD8BFD8),
            //ContentColor = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Spacer(modifier = Modifier.height(8.dp))
        TotalIncomeView(totalIncome = 1500000.0)
        Spacer(modifier = Modifier.height(65.dp))
        val context = LocalContext.current
        val intentMasterData = Intent(context, MasterData::class.java)
      //  val intentQr = Intent(context, Qr::class.java)
        val intentTransaction = Intent(context, SurfaceControl.Transaction::class.java)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MenuIcon(
                icon = painterResource(id = R.drawable.store),
                label = "STORE",
                onClick = {
                    navController.navigate(ROUTE_POSMasterData)
                }
            )
            MenuIcon(
                icon = painterResource(id = R.drawable.img_1),
                label = "PRODUCTS",
                onClick = {
                   navController.navigate(ROUTE_POSTransaction)

                }
            )
            MenuIcon(
                icon = painterResource(id = R.drawable.add),
                label = "ADD",
                onClick = {
                    navController.navigate(ROUTE_AddProduct)
                }
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "transactions ",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .padding(start = 10.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Transaction 1",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier
                            .padding(8.dp)
                            .padding(start = 20.dp)
                    )
                    Text(
                        text = "ksh.100",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier
                            .padding(8.dp)
                            .padding(end = 20.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Transaction 2",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier
                            .padding(8.dp)
                            .padding(start = 20.dp)
                    )
                    Text(
                        text = "ksh.230",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier
                            .padding(8.dp)
                            .padding(end = 20.dp)
                    )
                }
             TextButton(
                    onClick = {
                        navController.navigate(ROUTE_RECEIPT)},
                               modifier = Modifier
                                   .wrapContentSize()
                                   .align(Alignment.End),
                    colors = ButtonDefaults.textButtonColors(Color.Blue)
                ) {
                    Text(
                        text = "View Details",
                        color = Color.White
                    )
               }
            }
        }
    }
}

@Composable
fun MenuIcon(icon: Painter, label: String, onClick: () -> Unit) {
    
    Box(
        modifier = Modifier
            .size(120.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(color = Color.LightGray, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = label)
        }
    }
}


@Composable
fun TotalIncomeView(totalIncome: Double) {
    val formattedTotalIncome = NumberFormat.getCurrencyInstance(Locale("", "KE"))
        .format(totalIncome)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .height(80.dp)
            .background(color = Color.LightGray, shape = MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(100.dp)
                .background(color = Color.LightGray, shape = MaterialTheme.shapes.medium),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Total Income: ${formattedTotalIncome}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
fun MenuButton(text: String) {
    Button(
        onClick = {
            /* Action for menu item */
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(Color.Magenta),
        shape = MaterialTheme.shapes.medium,
        content = {
            Text(text = text)
        },
    )
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomePage(rememberNavController())
}

