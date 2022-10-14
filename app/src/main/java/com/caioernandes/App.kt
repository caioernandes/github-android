package com.caioernandes

import android.app.Application
import com.caioernandes.githubandroid.features.githubprojectlist.di.appModule
import com.caioernandes.network.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidContext(androidContext = this@App)
            modules(appModule, networkModule)
        }
    }
}