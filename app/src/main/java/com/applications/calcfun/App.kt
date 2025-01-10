package com.applications.calcfun

import android.app.Application
import com.applications.calcfun.di.dataModule
import com.applications.calcfun.di.interactorModule
import com.applications.calcfun.di.repositoryModule
import com.applications.calcfun.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModule, repositoryModule, interactorModule, viewModelModule)
        }
    }
}