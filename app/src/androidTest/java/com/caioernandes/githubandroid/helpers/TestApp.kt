package com.caioernandes.githubandroid.helpers

import android.app.Application
import com.caioernandes.githubandroid.features.githubprojectlist.di.appModule
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "http://127.0.0.1:8080"

class TestApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
            modules(networkAndroidTestModule)
        }
    }

    private val networkAndroidTestModule = module(override = true) {
        single {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val httpClient = OkHttpClient.Builder().addInterceptor { chain ->
                val request: Request = chain.request().newBuilder().build()
                chain.proceed(request)
            }
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
    }
}