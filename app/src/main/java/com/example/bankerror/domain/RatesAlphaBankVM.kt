package com.example.bankerror.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankerror.data.toDomain
import com.example.bankerror.domain.model.Rate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

sealed interface RateUIState {
    data class RateList(val rate: List<Rate>) : RateUIState
    object Error : RateUIState
    object Loading : RateUIState
}

@HiltViewModel
class RatesAlphaBankVM @Inject constructor(private val repository: Repository) : ViewModel() {
    var rateUIState: RateUIState by mutableStateOf(RateUIState.Loading)
        private set

    init {
        getRatesAlpha()
    }

    fun getRatesAlpha() {
        viewModelScope.launch {
            rateUIState = RateUIState.Loading
            rateUIState = try {
                RateUIState.RateList(repository.getRates().rate.map {
                    it.toDomain()
                })
            } catch (e: IOException) {
                RateUIState.Error
            } catch (e: HttpException) {
                RateUIState.Error
            }
        }
    }
}