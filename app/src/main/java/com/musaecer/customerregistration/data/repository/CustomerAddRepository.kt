package com.musaecer.customerregistration.data.repository

import com.musaecer.customerregistration.domain.model.Customer

interface CustomerAddRepository {
    suspend fun createCustomer(customer: Customer)
}