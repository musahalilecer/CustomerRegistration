package com.musaecer.customerregistration.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.musaecer.customerregistration.data.local.CustomerEntity
import com.musaecer.customerregistration.data.repository.CustomerRepository
import com.musaecer.customerregistration.domain.model.Customer
import com.musaecer.customerregistration.presentation.component.NavigationStack
import com.musaecer.customerregistration.presentation.component.Screen
import com.musaecer.customerregistration.presentation.component.SearchBar
import com.musaecer.customerregistration.presentation.util.CustomerEvent
import com.musaecer.customerregistration.presentation.viewmodel.CustomerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val vm: CustomerViewModel = viewModel()
    val state = vm.state.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Müşteri Kayıt") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.CustomerAdd.route) }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { padding ->
        Column(modifier.padding(padding)) {
            SearchBar(onSearch = { query ->
                vm.onEvent(CustomerEvent.Search(query))
            })
            UserListScreen(navController = navController)
        }
    }
}