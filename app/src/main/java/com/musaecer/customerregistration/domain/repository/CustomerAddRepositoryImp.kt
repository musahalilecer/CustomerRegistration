package com.musaecer.customerregistration.domain.repository

import com.musaecer.customerregistration.data.local.CustomerEntity
import com.musaecer.customerregistration.data.repository.CustomerAddRepository
import com.musaecer.customerregistration.domain.dao.CustomerDao
import com.musaecer.customerregistration.domain.model.Customer

class CustomerAddRepositoryImp(
    private val customerDao: CustomerDao
): CustomerAddRepository {
    override suspend fun createCustomer(customer: Customer) {
        customerDao.insert(
            CustomerEntity(
                id = customer.id,
                name = customer.name,
                surname = customer.surname,
                description = customer.descriptions,
                referenceCode = customer.referenceCode,
                phone = customer.phone
            )
        )
    }
}