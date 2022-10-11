package com.caioernandes.githubandroid.domain.repository

import com.caioernandes.githubandroid.domain.model.GithubProjectData
import kotlinx.coroutines.flow.Flow

interface GithubProjectListRepository {

    suspend fun getGithubProjectList(): Flow<GithubProjectData>
}