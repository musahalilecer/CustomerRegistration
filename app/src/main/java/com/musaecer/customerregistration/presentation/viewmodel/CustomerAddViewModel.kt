package com.musaecer.customerregistration.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.musaecer.customerregistration.data.repository.CustomerAddRepository
import com.musaecer.customerregistration.data.repository.CustomerRepository
import com.musaecer.customerregistration.domain.dao.CustomerDao
import com.musaecer.customerregistration.domain.model.Customer
import com.musaecer.customerregistration.presentation.util.CustomerEvent
import com.musaecer.customerregistration.presentation.util.CustomerState
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CustomerAddViewModel(
    private val customerRepository: CustomerAddRepository
): ViewModel() {
    private val _state = mutableStateOf<CustomerState>(CustomerState())
    var state: State<CustomerState> = _state

    var job: Job? = null

    fun onEvent(event: CustomerEvent){
        when(event){
            is CustomerEvent.Add -> createCustomer(event.customer)
            is CustomerEvent.Delete -> TODO()
            is CustomerEvent.Search -> TODO()
            is CustomerEvent.SearchId -> TODO()
            CustomerEvent.loadAll -> TODO()
        }
    }

    fun createCustomer(customer: Customer) = viewModelScope.launch {
        customerRepository.createCustomer(customer)
        onEvent(CustomerEvent.loadAll)
    }
}