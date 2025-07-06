package com.musaecer.customerregistration.domain.model

data class Customer(
    val id: Int,
    val name: String,
    val surname: String,
    val referenceCode: String,
    val descriptions: String,
    val phone: String
)
