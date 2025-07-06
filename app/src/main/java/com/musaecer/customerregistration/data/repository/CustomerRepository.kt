package com.musaecer.customerregistration.data.repository

import com.musaecer.customerregistration.domain.model.Customer
import kotlinx.coroutines.flow.Flow


interface CustomerRepository {
    fun getAllCustomers(): Flow<List<Customer>>
    fun getCustomerByName(query: String): Flow<List<Customer>>
   /* suspend fun insertCustomer(customer: Customer)
    suspend fun deleteCustomer(id: Int)

    */
}
