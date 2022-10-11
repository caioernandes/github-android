package com.caioernandes.githubandroid.data.datasource

import com.caioernandes.githubandroid.data.api.GithubProjectListService
import com.caioernandes.githubandroid.data.mapper.toDomain
import com.caioernandes.githubandroid.domain.model.GithubProjectData

class GithubProjectListRemoteDataSourceImpl(
    private val service: GithubProjectListService
) : GithubProjectListRemoteDataSource {

    override suspend fun getGithubProjectList(): GithubProjectData {
        return service.getGithubProjectList().toDomain()
    }
}