package com.example.bankerror.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankerror.domain.RepositoryIn
import com.example.bankerror.domain.models.DataAlpha
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RatesAlphaBankVM (private val repositoryIn: RepositoryIn):ViewModel() {

    //пустой список StateFlow
    private val _itemsStateFlow: MutableStateFlow<List<DataAlpha>> = MutableStateFlow(emptyList())

    //для observe
    val itemsStateFlow: MutableStateFlow<List<DataAlpha>> get() = _itemsStateFlow

    fun getRatesAlpha() {
        viewModelScope.launch {
            val listExchangeRatesResponse = repositoryIn.getListExchangeRatesAlpha()
            _itemsStateFlow.value = listOf(listExchangeRatesResponse)
        }
    }
}