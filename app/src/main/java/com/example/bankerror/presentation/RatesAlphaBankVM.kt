package com.example.bankerror.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankerror.data.toDomain
import com.example.bankerror.domain.Repository
import com.example.bankerror.domain.model.Rate
import kotlinx.coroutines.launch

sealed interface RateUIState {
    data class RateList(val rate: List<Rate>) : RateUIState
    data object Error : RateUIState
    data object Loading : RateUIState
}

class RatesAlphaBankVM(private val repository: Repository) : ViewModel() {

    var rateUIState: RateUIState by mutableStateOf(RateUIState.Loading)
        private set

    init {
        getRatesAlpha()
    }

    fun getRatesAlpha() {
        viewModelScope.launch {
            rateUIState = RateUIState.Loading
            val result = repository.getRates()
            result.fold(onSuccess = { data ->
                rateUIState = RateUIState.RateList(data.rate.map { it.toDomain() })
            }, onFailure = {
                rateUIState = RateUIState.Error
            })
        }
    }
}