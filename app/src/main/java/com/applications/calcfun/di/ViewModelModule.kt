package com.applications.calcfun.di

import com.applications.calcfun.generator.presentation.CalcViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        CalcViewModel(get())
    }
}