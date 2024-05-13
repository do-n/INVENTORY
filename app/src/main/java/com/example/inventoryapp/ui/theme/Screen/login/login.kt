package com.example.inventoryapp.ui.theme.Screen.login

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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventoryapp.Data.AuthViewModel
import com.example.inventoryapp.Navigation.Routes.ROUTE_HOMEPAGE
import com.example.inventoryapp.Navigation.Routes.ROUTE_REGISTER
import com.example.inventoryapp.R

@Composable
fun LoginScreen(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.solid),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

    }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(top = 320.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .background(
                color = Color.Unspecified,
                shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp)
            ),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = "   Sign In",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = email, onValueChange = { email = it },
            label = { Text(text = "Enter Email") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = pass, onValueChange = { pass = it },
            label = { Text(text = "Enter Password") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
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
            Text(text = "Log In")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_REGISTER)
        }, modifier = Modifier.fillMaxWidth()) {

            TextComponent(text = "Don't have account? Click to Register")
        }

    }

}

@Preview
@Composable
fun Loginpage() {
    LoginScreen(rememberNavController())

}
@Composable
fun TextComponent(text: String) {
    Text(modifier = Modifier, text = text, fontSize = 18.sp)
}
