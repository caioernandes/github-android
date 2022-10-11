package com.caioernandes.githubandroid.features.githubprojectlist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.GithubProjectData
import com.caioernandes.githubandroid.features.githubprojectlist.domain.usecase.GetGithubProjectListUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class GithubProjectListViewModel(
    private val getGithubProjectListUseCase: GetGithubProjectListUseCase
) : ViewModel() {

    private val _viewState = MutableLiveData<GithubProjectListViewState>()
    val viewState: LiveData<GithubProjectListViewState> = _viewState

    init {
        onGetGithubProjectList()
    }

    private fun onGetGithubProjectList() {
        viewModelScope.launch {
            getGithubProjectListUseCase()
                .onStart { emitLoadingState(isLoading = true) }
                .onCompletion { emitLoadingState(isLoading = false) }
                .catch { emitMessageErrorState(throwable = it) }
                .collect(::emitMovieCollectionResultState)
        }
    }

    private fun emitLoadingState(isLoading: Boolean) {
        _viewState.value = GithubProjectListViewState.Loading(isLoading = isLoading)
    }

    private fun emitMessageErrorState(throwable: Throwable) {
        _viewState.value = GithubProjectListViewState.Failure(error = throwable.message.orEmpty())
    }

    private fun emitMovieCollectionResultState(githubProjectData: GithubProjectData) {
        _viewState.value = GithubProjectListViewState.Success(githubProjectData = githubProjectData)
    }
}