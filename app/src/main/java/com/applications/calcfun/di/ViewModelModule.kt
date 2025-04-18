package com.applications.calcfun.di

import com.applications.calcfun.generator.presentation.CalcViewModel
import com.applications.calcfun.main.presentation.MainViewModel
import com.applications.calcfun.score.presentation.ScoreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        CalcViewModel(get(), get())
    }
    viewModel {
        ScoreViewModel(get())
    }
    viewModel {
        MainViewModel(get())
    }
}