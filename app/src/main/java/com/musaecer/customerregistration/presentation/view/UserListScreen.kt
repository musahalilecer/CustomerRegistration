package com.musaecer.customerregistration.presentation.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.musaecer.customerregistration.data.local.CustomerEntity
import com.musaecer.customerregistration.domain.model.Customer
import com.musaecer.customerregistration.presentation.component.Screen
import com.musaecer.customerregistration.presentation.viewmodel.CustomerViewModel

@Composable
fun UserListScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val vm: CustomerViewModel = viewModel()

    val uiState by vm.state.collectAsState()
    val customers = uiState.customers

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(customers) { customer ->
            CustomerCard(customer, navController, modifier)
        }
    }
}

@Composable
fun CustomerCard(
    customer: Customer,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable {
                navController.navigate("${Screen.UserDetail.route}/${customer.id}")
            },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(Modifier.padding(16.dp)) {
            Text("${customer.name} ${customer.surname}")
        }
    }
}