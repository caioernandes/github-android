package com.caioernandes.githubandroid.di

import com.caioernandes.githubandroid.data.api.GithubProjectListService
import com.caioernandes.githubandroid.data.datasource.GithubProjectListRemoteDataSourceImpl
import com.caioernandes.githubandroid.data.repository.GithubProjectListRepositoryImpl
import com.caioernandes.githubandroid.domain.usecase.GetGithubProjectListUseCase
import com.caioernandes.githubandroid.presentation.GithubProjectListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    viewModel {
        GithubProjectListViewModel(
            getGithubProjectListUseCase = GetGithubProjectListUseCase(
                repository = GithubProjectListRepositoryImpl(
                    dataSource = GithubProjectListRemoteDataSourceImpl(
                        service = get<Retrofit>().create(GithubProjectListService::class.java)
                    )
                )
            )
        )
    }
}