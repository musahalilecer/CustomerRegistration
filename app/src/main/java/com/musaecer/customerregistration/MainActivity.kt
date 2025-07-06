package com.musaecer.customerregistration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController

import com.musaecer.customerregistration.domain.repository.CustomerRepositoryImp
import com.musaecer.customerregistration.domain.use_case.ApplicationDatabase
import com.musaecer.customerregistration.presentation.component.NavigationStack
import com.musaecer.customerregistration.presentation.view.HomeScreen
import com.musaecer.customerregistration.presentation.viewmodel.CustomerViewModel
import com.musaecer.customerregistration.ui.theme.CustomerRegistrationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomerRegistrationTheme {
                val navController = rememberNavController()
                NavigationStack(navController = navController)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomerRegistrationTheme {
        Greeting("Android")
    }
}