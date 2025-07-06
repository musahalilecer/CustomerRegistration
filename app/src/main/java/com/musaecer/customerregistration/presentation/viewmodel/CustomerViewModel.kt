package com.musaecer.customerregistration.presentation.viewmodel

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.musaecer.customerregistration.data.repository.CustomerRepository
import com.musaecer.customerregistration.domain.model.Customer
import com.musaecer.customerregistration.domain.repository.CustomerRepositoryImp
import com.musaecer.customerregistration.domain.use_case.ApplicationDatabase
import com.musaecer.customerregistration.presentation.util.CustomerEvent
import com.musaecer.customerregistration.presentation.util.CustomerState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CustomerViewModel(application: Application) : AndroidViewModel(application) {

    // --- Repository’i burada oluşturuyoruz ---
    private val dao = ApplicationDatabase.getInstance(application).customerDao()
    private val repo: CustomerRepository = CustomerRepositoryImp(dao)

    // --- UI state ---
    private val _state = MutableStateFlow(CustomerState())
    val state: StateFlow<CustomerState> = _state

    init {
        onEvent(CustomerEvent.loadAll)
    }

    fun onEvent(event: CustomerEvent) {
        when (event) {
            is CustomerEvent.loadAll -> loadAll()
            is CustomerEvent.Search -> search(event.search)
            is CustomerEvent.Add -> TODO()
            is CustomerEvent.Delete -> TODO()
            is CustomerEvent.SearchId -> TODO()
            CustomerEvent.loadAll -> TODO()
        }
    }

    private fun loadAll() {
        viewModelScope.launch {
            repo.getAllCustomers()
                .catch { e ->
                    _state.value = state.value.copy(error = e.localizedMessage ?: "")
                }
                .collect { list ->
                    _state.value = state.value.copy(customers = list)
                }
        }
    }

    private fun search(query: String) {
        viewModelScope.launch {
            repo.getCustomerByName(query)
                .catch { e ->
                    _state.value = state.value.copy(error = e.localizedMessage ?: "")
                }
                .collect { list ->
                    _state.value = state.value.copy(customers = list)
                }
        }
    }
}