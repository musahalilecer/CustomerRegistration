package com.musaecer.customerregistration.domain.repository

import com.musaecer.customerregistration.data.repository.CustomerRepository
import com.musaecer.customerregistration.domain.dao.CustomerDao
import com.musaecer.customerregistration.domain.model.Customer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CustomerRepositoryImp(
    private val customerDao: CustomerDao
): CustomerRepository {

    override fun getAllCustomers(): Flow<List<Customer>> =
        customerDao.getAll().map { entityList ->
            entityList.map { entity ->
                Customer(
                    id = entity.id,
                    name = entity.name,
                    surname = entity.surname,
                    phone = entity.phone,
                    descriptions = entity.description,
                    referenceCode = entity.referenceCode
                )
            }
        }

    override fun getCustomerByName(query: String): Flow<List<Customer>> =
        customerDao.getByName(query).map { entityList ->
            entityList.map { entity ->
                Customer(
                    id = entity.id,
                    name = entity.name,
                    surname = entity.surname,
                    phone = entity.phone,
                    descriptions = entity.description,
                    referenceCode = entity.referenceCode
                )
            }
        }
}