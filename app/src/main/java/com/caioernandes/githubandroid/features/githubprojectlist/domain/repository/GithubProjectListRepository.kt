package com.caioernandes.githubandroid.features.githubprojectlist.domain.repository

import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.GithubProjectData
import kotlinx.coroutines.flow.Flow

interface GithubProjectListRepository {

    suspend fun getGithubProjectList(page: Int): Flow<GithubProjectData>
}