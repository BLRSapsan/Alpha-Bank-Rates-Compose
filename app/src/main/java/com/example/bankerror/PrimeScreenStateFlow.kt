package com.example.bankerror

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankerror.data.Repository
import com.example.bankerror.domain.DataAlpha
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PrimeScreenStateFlow:ViewModel() {

    private val repository = Repository()

    //пустой список StateFlow
    private val _itemsStateFlow: MutableStateFlow<List<DataAlpha>> = MutableStateFlow(emptyList())
    //для observe 
    val itemsStateFlow: MutableStateFlow<List<DataAlpha>> get() = _itemsStateFlow

    fun fetchItems() {
        viewModelScope.launch {
            val items = repository.getRateAlpha()
            _itemsStateFlow.value = listOf(items)
        }
    }
}