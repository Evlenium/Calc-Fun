package com.applications.calcfun.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val TOTAL_SCORE = "total_score"
val dataModule = module {
    single(named(TOTAL_SCORE)) {
        androidContext().getSharedPreferences(TOTAL_SCORE, Context.MODE_PRIVATE)
    }
}