package com.example.bankerror.delete

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankerror.TAGbank
import com.example.bankerror.data.Repository
import com.example.bankerror.domain.DataAlpha
import kotlinx.coroutines.launch

class PrimeScreen: ViewModel() {
    private var repository = Repository()
    var alphaListLiveData: MutableLiveData<DataAlpha> = MutableLiveData()

    fun getRateAlpha() {
        viewModelScope.launch {
            Log.i(TAGbank, "class PrimeScreen:getRateAlpha: полученние данных курса альфа-банка в пустой лист")
            //alphaListLiveData - объект класса livedata, который хранит значения <string>
            alphaListLiveData.value= repository.getRateAlpha()
            Log.i(TAGbank, "полученные данные курса Альфа-банка ${alphaListLiveData.value.toString()}")
        }
    }
}