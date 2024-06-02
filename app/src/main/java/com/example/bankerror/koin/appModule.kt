package com.example.bankerror.koin

import com.example.bankerror.RatesAlphaBankVM
import com.example.bankerror.data.RepositoryList
import com.example.bankerror.data.RepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { RatesAlphaBankVM(get()) }

    single<RepositoryList> { RepositoryImpl() }

}