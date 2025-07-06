package com.musaecer.customerregistration.data.repository

interface CustomerDetailRepository {
    fun getCustomerById(id: Int)
    suspend fun deleteCustomer(id: Int)
}