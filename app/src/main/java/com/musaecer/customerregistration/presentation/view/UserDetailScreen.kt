package com.musaecer.customerregistration.presentation.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.musaecer.customerregistration.data.repository.CustomerDetailRepository
import com.musaecer.customerregistration.data.repository.CustomerRepository
import com.musaecer.customerregistration.domain.model.Customer
import com.musaecer.customerregistration.domain.repository.CustomerDetailRepositoryImp
import com.musaecer.customerregistration.presentation.viewmodel.CustomerDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailScreen(
    navController: NavController,
    customer: Customer
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detay: ${customer.name}") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            Text("ID: ${customer.id}")
            Spacer(Modifier.height(8.dp))
            Text("Adı: ${customer.name}")
            Text("Soyadı: ${customer.surname}")
            Text("Telefon: ${customer.phone}")
            Text("Açıklama: ${customer.descriptions}")
            Text("Ref Code: ${customer.referenceCode}")
        }
    }
}