package com.caioernandes.githubandroid.features.githubprojectlist.data.datasource.local

import com.caioernandes.githubandroid.features.githubprojectlist.data.model.entities.GithubProject
import com.caioernandes.githubandroid.features.githubprojectlist.data.model.entities.ResultGithubDataEntity
import com.caioernandes.githubandroid.features.githubprojectlist.data.model.entities.ResultGithubDataWithGithubProject
import kotlinx.coroutines.flow.Flow

interface GithubDataLocalDataSource {

    fun getAllGithubProjectList(): Flow<ResultGithubDataWithGithubProject>

    suspend fun insertFullResultGithubData(
        resultData: ResultGithubDataEntity,
        repositoryListEntity: List<GithubProject>,
    )
}