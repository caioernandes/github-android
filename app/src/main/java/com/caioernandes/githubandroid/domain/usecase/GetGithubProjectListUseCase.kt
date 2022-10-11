package com.caioernandes.githubandroid.domain.usecase

import com.caioernandes.githubandroid.domain.model.GithubProjectData
import com.caioernandes.githubandroid.domain.usecase.repository.GithubProjectListRepository
import kotlinx.coroutines.flow.Flow

class GetGithubProjectListUseCase(private val repository: GithubProjectListRepository) {

    suspend operator fun invoke(): Flow<GithubProjectData> {
        return repository.getGithubProjectList()
    }
}