package com.musaecer.customerregistration.presentation.util

import com.musaecer.customerregistration.domain.model.Customer

data class CustomerState(
    val isLoading: Boolean = false,
    val customers: List<Customer> = emptyList(),
    val error: String = "",
    val search: String = "Enter the Customer"
)

