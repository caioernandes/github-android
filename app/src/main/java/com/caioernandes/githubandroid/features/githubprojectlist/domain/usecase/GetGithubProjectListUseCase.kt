package com.caioernandes.githubandroid.features.githubprojectlist.domain.usecase

import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.GithubProjectData
import com.caioernandes.githubandroid.features.githubprojectlist.domain.repository.GithubProjectListRepository
import kotlinx.coroutines.flow.Flow

class GetGithubProjectListUseCase(private val repository: GithubProjectListRepository) {

    suspend operator fun invoke(page: Int): Flow<GithubProjectData> {
        return repository.getGithubProjectList(page = page)
    }
}