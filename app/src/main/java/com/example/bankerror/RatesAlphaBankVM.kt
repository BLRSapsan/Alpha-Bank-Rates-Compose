package com.example.bankerror

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankerror.data.Repository
import com.example.bankerror.models.DataAlpha
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RatesAlphaBankVM:ViewModel() {

    private val repository = Repository()

    //пустой список StateFlow
    private val _itemsStateFlow: MutableStateFlow<List<DataAlpha>> = MutableStateFlow(emptyList())
    //для observe 
    val itemsStateFlow: MutableStateFlow<List<DataAlpha>> get() = _itemsStateFlow

    fun getRatesAlpha() {
        viewModelScope.launch {
            val listExchangeRatesResponse = repository.getListExchangeRatesAlpha()
            _itemsStateFlow.value = listOf(listExchangeRatesResponse)
        }
    }
}