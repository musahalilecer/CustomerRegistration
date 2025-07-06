package com.musaecer.customerregistration.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.musaecer.customerregistration.data.local.CustomerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {

    @Insert
    fun insert(vararg customers: CustomerEntity): List<Long>

    @Query("SELECT * FROM customers")
    fun getAll(): Flow<List<CustomerEntity>>

    @Query("SELECT * FROM customers WHERE id = :customerId")
    fun getById(customerId: Int): CustomerEntity?

    @Query("SELECT * FROM customers WHERE name LIKE '%' || :query || '%' OR surname LIKE '%' || :query || '%'")
    fun getByName(query: String): Flow<List<CustomerEntity>>

    @Query("DELETE FROM customers WHERE id = :customerId")
    suspend fun delete(customerId: Int): Int

}