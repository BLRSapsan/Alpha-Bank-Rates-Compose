package com.example.bankerror.domain.koin

import com.example.bankerror.domain.RatesAlphaBankVM
import com.example.bankerror.domain.RepositoryIn
import com.example.bankerror.data.RepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { RatesAlphaBankVM(get()) }

    single<RepositoryIn> { RepositoryImpl() }

}