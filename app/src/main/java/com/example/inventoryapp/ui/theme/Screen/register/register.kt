package com.example.inventory.ui.theme.Screen.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventoryapp.Data.AuthViewModel
import com.example.inventoryapp.Navigation.Routes.ROUTE_HOMEPAGE
import com.example.inventoryapp.Navigation.Routes.ROUTE_LOGIN
import com.example.inventoryapp.R

@Composable
fun RegisterScreen(navController:NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.liquid),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

    }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current
    Column(
        modifier = Modifier
            .padding(top = 215.dp, start = 0.dp, end = 0.dp)
            .fillMaxWidth()
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp)
            ),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = "   Sign Up",
            style = MaterialTheme.typography.headlineMedium
        )
        OutlinedTextField(
            value = email, onValueChange = { email = it },
            label = { Text(text = "Enter Email", color = Color.Black,) },

            keyboardOptions = KeyboardOptions . Default . copy (imeAction = androidx.compose.ui.text.input.ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =pass , onValueChange = {pass=it},
            label = { Text(text = "Enter password", color = Color.Black,) },
            keyboardOptions = KeyboardOptions.run { Default.copy(imeAction = androidx.compose.ui.text.input.ImeAction.Next) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value =confirmpass , onValueChange = {
            confirmpass=it},
            label = { Text(text = "Confirm Pass", color = Color.Black,) },

            keyboardOptions = KeyboardOptions.Default.copy(imeAction = androidx.compose.ui.text.input.ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val myregister= AuthViewModel(navController,context)
            myregister.signup(email.text.trim(),pass.text.trim(),confirmpass.text.trim())
            navController.navigate(ROUTE_HOMEPAGE)


        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Register ")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Have an Account? Click to Login")
        }

    }



}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Register() {
    RegisterScreen(rememberNavController())
}