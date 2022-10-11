package com.caioernandes.githubandroid.features.githubprojectlist.presentation

import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.GithubProjectData

sealed class GithubProjectListViewState {

    data class Loading(val isLoading: Boolean) : GithubProjectListViewState()

    data class Failure(val error: String) : GithubProjectListViewState()

    data class Success(val githubProjectData: GithubProjectData) : GithubProjectListViewState()
}
