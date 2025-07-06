package com.musaecer.customerregistration.presentation.util

import com.musaecer.customerregistration.domain.model.Customer

sealed class CustomerEvent {
    object loadAll: CustomerEvent()
    data class Search(val search: String): CustomerEvent()
    data class SearchId(val id: Int): CustomerEvent()
    data class Add(val customer: Customer): CustomerEvent()
    data class Delete(val id: Int): CustomerEvent()
}