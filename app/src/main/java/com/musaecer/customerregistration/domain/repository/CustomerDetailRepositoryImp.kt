package com.musaecer.customerregistration.domain.repository

import com.musaecer.customerregistration.data.local.CustomerEntity
import com.musaecer.customerregistration.data.repository.CustomerDetailRepository
import com.musaecer.customerregistration.data.repository.CustomerRepository
import com.musaecer.customerregistration.domain.dao.CustomerDao
import com.musaecer.customerregistration.domain.model.Customer
import kotlinx.coroutines.flow.Flow

class CustomerDetailRepositoryImp(
    private val customerDao: CustomerDao
): CustomerDetailRepository {
    override fun getCustomerById(id: Int) {
        customerDao.getById(id)
    }

    override suspend fun deleteCustomer(id: Int) {
        customerDao.delete(id)
    }

}