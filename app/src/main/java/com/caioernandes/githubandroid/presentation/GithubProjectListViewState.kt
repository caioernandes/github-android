package com.caioernandes.githubandroid.presentation

import com.caioernandes.githubandroid.domain.model.GithubProjectData

sealed class GithubProjectListViewState {

    data class Loading(val isLoading: Boolean) : GithubProjectListViewState()

    data class Failure(val error: String) : GithubProjectListViewState()

    data class Success(val githubProjectData: GithubProjectData) : GithubProjectListViewState()
}
