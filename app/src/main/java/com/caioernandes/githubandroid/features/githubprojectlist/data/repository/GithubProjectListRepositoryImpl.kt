package com.caioernandes.githubandroid.features.githubprojectlist.data.repository

import com.caioernandes.githubandroid.features.githubprojectlist.data.datasource.local.GithubDataLocalDataSource
import com.caioernandes.githubandroid.features.githubprojectlist.data.datasource.remote.GithubProjectListRemoteDataSource
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.GithubProjectData
import com.caioernandes.githubandroid.features.githubprojectlist.domain.repository.GithubProjectListRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

class GithubProjectListRepositoryImpl(
    private val remoteDataSource: GithubProjectListRemoteDataSource,
    private val localDataSource: GithubDataLocalDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): GithubProjectListRepository {

    override suspend fun getGithubProjectList(page: Int): Flow<GithubProjectData> {
        return flowOf(remoteDataSource.getGithubProjectList(page = page)).flowOn(dispatcher)
    }
}