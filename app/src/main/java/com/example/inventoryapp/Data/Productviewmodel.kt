package com.example.inventoryapp.Data

import android.app.ProgressDialog
import android.content.Context
import com.example.inventoryapp.Navigation.Routes.ROUTE_HOMEPAGE
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class ProductViewModel(var navController: ProductAdd, var context: Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog
    // var name by remember { mutableStateOf("") }
    //var price by remember { mutableStateOf("") }
    //var stock by remember { mutableStateOf("") }
    ///var description by remember { mutableStateOf("") }
    //var imageUri by remember { mutableStateOf<Uri?>(null) }
    //var isBottomSheetVisible by remember { mutableStateOf(false) }
    //var showDialog by remember { mutableStateOf(false) }


    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_HOMEPAGE)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }


    fun saveProduct(
        productName: String,
        productQuantity: String,
        productPrice: String,
        description: Any?,
        imageUri: Any?,
        stock: Any?,
        price: Any?,
        name: Any?
    ) {
        var id = System.currentTimeMillis().toString()
        var productData = Product(name, price, stock, description, imageUri)
        var productRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        productRef.setValue(productData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun deleteProduct(id: String) {
        var delRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Product deleted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

