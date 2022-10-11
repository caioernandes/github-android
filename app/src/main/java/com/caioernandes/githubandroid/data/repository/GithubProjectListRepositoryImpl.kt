package com.caioernandes.githubandroid.data.repository

import com.caioernandes.githubandroid.data.datasource.GithubProjectListRemoteDataSource
import com.caioernandes.githubandroid.domain.model.GithubProjectData
import com.caioernandes.githubandroid.domain.usecase.repository.GithubProjectListRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

class GithubProjectListRepositoryImpl(
    private val dataSource: GithubProjectListRemoteDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): GithubProjectListRepository {

    override suspend fun getGithubProjectList(): Flow<GithubProjectData> {
        return flowOf(dataSource.getGithubProjectList()).flowOn(dispatcher)
    }
}