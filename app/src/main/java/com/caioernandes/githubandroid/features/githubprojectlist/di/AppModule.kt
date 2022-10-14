package com.caioernandes.githubandroid.features.githubprojectlist.di

import com.caioernandes.githubandroid.features.githubprojectlist.data.api.GithubProjectListService
import com.caioernandes.githubandroid.features.githubprojectlist.data.datasource.local.GithubDataLocalDataSourceImpl
import com.caioernandes.githubandroid.features.githubprojectlist.data.datasource.remote.GithubProjectListRemoteDataSourceImpl
import com.caioernandes.githubandroid.features.githubprojectlist.data.db.AppDatabase
import com.caioernandes.githubandroid.features.githubprojectlist.data.repository.GithubProjectListRepositoryImpl
import com.caioernandes.githubandroid.features.githubprojectlist.domain.usecase.GetGithubProjectListUseCase
import com.caioernandes.githubandroid.features.githubprojectlist.presentation.GithubProjectListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    viewModel {
        GithubProjectListViewModel(
            getGithubProjectListUseCase = GetGithubProjectListUseCase(
                repository = GithubProjectListRepositoryImpl(
                    remoteDataSource = GithubProjectListRemoteDataSourceImpl(
                        service = get<Retrofit>().create(GithubProjectListService::class.java)
                    ),
                    localDataSource = GithubDataLocalDataSourceImpl(dao = get())
                )
            )
        )
    }
    single { get<AppDatabase>().githubProjectListDao() }
}