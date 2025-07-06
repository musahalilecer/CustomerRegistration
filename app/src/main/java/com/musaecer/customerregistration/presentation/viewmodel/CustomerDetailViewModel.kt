package com.musaecer.customerregistration.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.musaecer.customerregistration.data.repository.CustomerDetailRepository
import com.musaecer.customerregistration.presentation.util.CustomerEvent
import com.musaecer.customerregistration.presentation.util.CustomerState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CustomerDetailViewModel(
    val customerDetailRepository: CustomerDetailRepository
): ViewModel() {
    private val _state = mutableStateOf<CustomerState>(CustomerState())
    val state: State<CustomerState> = _state

    private var job: Job? = null

    fun onEvent(event: CustomerEvent){
        when(event){
            is CustomerEvent.Delete -> deleteCustomer(event.id)
            is CustomerEvent.SearchId -> getCustomerById(event.id)
            is CustomerEvent.Add -> TODO()
            is CustomerEvent.Search -> TODO()
            CustomerEvent.loadAll -> TODO()
        }
    }

    fun getCustomerById(id: Int){
        job?.cancel()
        _state.value = state.value.copy(isLoading = true, error = "")
        job = viewModelScope.launch {
            customerDetailRepository.getCustomerById(id)

        }
    }

    fun deleteCustomer(id: Int) = viewModelScope.launch{
        customerDetailRepository.deleteCustomer(id)
        onEvent(CustomerEvent.loadAll)
    }
}