package com.caioernandes.githubandroid.features.githubprojectlist.data.datasource.local

import com.caioernandes.githubandroid.features.githubprojectlist.data.dao.GithubProjectListDao
import com.caioernandes.githubandroid.features.githubprojectlist.data.model.entities.GithubProject
import com.caioernandes.githubandroid.features.githubprojectlist.data.model.entities.ResultGithubDataEntity
import com.caioernandes.githubandroid.features.githubprojectlist.data.model.entities.ResultGithubDataWithGithubProject
import kotlinx.coroutines.flow.Flow

class GithubDataLocalDataSourceImpl(
    private val dao: GithubProjectListDao
) : GithubDataLocalDataSource {

    override fun getAllGithubProjectList(): Flow<ResultGithubDataWithGithubProject> {
        return dao.getAllGithubProjectList()
    }

    override suspend fun insertFullResultGithubData(
        resultData: ResultGithubDataEntity,
        repositoryListEntity: List<GithubProject>,
    ) {
        dao.insertFullResultGithubData(
            resultData = resultData,
            repositoryListEntity = repositoryListEntity
        )
    }
}