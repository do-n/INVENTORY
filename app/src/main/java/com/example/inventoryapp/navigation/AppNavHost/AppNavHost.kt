package com.example.inventoryapp.navigation.AppNavHost
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.deaenita.posfinalproject.POSMasterData
import com.example.inventory.ui.theme.Screen.register.RegisterScreen
import com.example.inventoryapp.HomePage
import com.example.inventoryapp.Navigation.Routes.ROUTE_AddProduct
import com.example.inventoryapp.Navigation.Routes.ROUTE_HOMEPAGE
import com.example.inventoryapp.Navigation.Routes.ROUTE_LOGIN
import com.example.inventoryapp.Navigation.Routes.ROUTE_POSMasterData
import com.example.inventoryapp.Navigation.Routes.ROUTE_POSTransaction
import com.example.inventoryapp.Navigation.Routes.ROUTE_QR
import com.example.inventoryapp.Navigation.Routes.ROUTE_RECEIPT
import com.example.inventoryapp.Navigation.Routes.ROUTE_REGISTER
import com.example.inventoryapp.Navigation.Routes.ROUTE_TRANSACTION
import com.example.inventoryapp.ui.theme.Screen.AddProduct.AddProductScreen
import com.example.inventoryapp.ui.theme.Screen.MasterData.POSMasterData
import com.example.inventoryapp.ui.theme.Screen.POSTransaction.POSTransaction
import com.example.inventoryapp.ui.theme.Screen.Transaction.TransactionSuccessDialog
import com.example.inventoryapp.ui.theme.Screen.login.LoginScreen
import com.example.inventoryappp.ui.theme.Screen.Receipt.ReceiptScreen
import com.example.myapplication.ui.theme.Screen.QR.QrContent

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(modifier: Modifier =Modifier, navController: NavHostController= rememberNavController(), startDestination:String= ROUTE_REGISTER) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }
        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_POSMasterData) {
            POSMasterData(navController)
        }
        composable(ROUTE_POSTransaction) {
            POSTransaction(navController,)
        }
          composable(ROUTE_TRANSACTION) {
           TransactionSuccessDialog(navController,)
           }
        composable(ROUTE_RECEIPT) {
            ReceiptScreen(navController,)
        }
        composable(ROUTE_AddProduct) {
            AddProductScreen(navController,)
        }

        composable(ROUTE_HOMEPAGE) {
            HomePage(navController)
        }
    }
}





