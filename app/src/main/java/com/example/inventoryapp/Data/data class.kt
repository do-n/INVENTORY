package com.example.inventoryapp.Data

import android.content.Intent
import android.net.Uri

class Product(name: Any?, price: Any?, stock: Any?, description: Any?, imageUri: Any?) {

}

class ProductTransaction<tonumberformat>(id: Int, name: String, price: Double, cabai: Int) {


    val imageResId: Int = 0
    val name: Any = TODO()
    val price: tonumberformat = TODO()

}

class PrintReceipt {

}

object intentPrintreceipt : Intent() {

}

data class ProductAdd(
    val name: String,
    val price: String,
    val stock: String,
    val description: String,
    val imageUri: Uri?
) {
    fun navigate(routeHomepage: String) {
        TODO("Not yet implemented")
    }
}