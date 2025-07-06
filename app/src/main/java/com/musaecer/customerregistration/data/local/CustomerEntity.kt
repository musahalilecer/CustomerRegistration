package com.musaecer.customerregistration.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customers")
data class CustomerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val surname: String,
    val description: String,
    val referenceCode: String,
    val phone: String
)
