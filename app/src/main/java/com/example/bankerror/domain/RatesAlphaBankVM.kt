package com.example.bankerror.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankerror.data.toDomain
import com.example.bankerror.domain.model.Rate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RatesAlphaBankVM(private val repository: Repository) : ViewModel() {

    private val _itemsStateFlow: MutableStateFlow<List<Rate>> =
        MutableStateFlow(emptyList())
    val itemsStateFlow: StateFlow<List<Rate>> get() = _itemsStateFlow
    fun getRatesAlpha() {
        viewModelScope.launch {
            _itemsStateFlow.value = repository.getRates().rate.map {
                it.toDomain()
            }
        }
    }
}