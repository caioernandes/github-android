package com.caioernandes.githubandroid.features.githubprojectlist.di

import com.caioernandes.githubandroid.features.githubprojectlist.data.db.AppDatabase
import org.koin.dsl.module

val dataBaseModule = module { single { AppDatabase.getDatabase(get()) } }