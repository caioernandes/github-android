package com.caioernandes.githubandroid.domain.usecase.repository

import com.caioernandes.githubandroid.domain.model.GithubProjectData
import kotlinx.coroutines.flow.Flow

interface GithubProjectListRepository {

    suspend fun getGithubProjectList(): Flow<GithubProjectData>
}