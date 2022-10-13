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

private const val INITIAL_PAGE_INDEX = 0

class GithubProjectListViewModel(
    private val getGithubProjectListUseCase: GetGithubProjectListUseCase
) : ViewModel() {

    private var page = INITIAL_PAGE_INDEX

    private val _viewState = MutableLiveData<GithubProjectListViewState>()
    val viewState: LiveData<GithubProjectListViewState> = _viewState

    fun onGetGithubProjectList() {
        page++
        getGithubProjectList()
    }

    private fun getGithubProjectList() {
        viewModelScope.launch {
            getGithubProjectListUseCase(page = page)
                .onStart { emitLoadingState(isLoading = true) }
                .onCompletion { emitLoadingState(isLoading = false) }
                .catch { emitMessageErrorState(throwable = it) }
                .collect(::emitGithubProjectListResultState)
        }
    }

    private fun emitLoadingState(isLoading: Boolean) {
        _viewState.value = GithubProjectListViewState.Loading(isLoading = isLoading)
    }

    private fun emitMessageErrorState(throwable: Throwable) {
        _viewState.value = GithubProjectListViewState.Failure(error = throwable.message.orEmpty())
    }

    private fun emitGithubProjectListResultState(githubProjectData: GithubProjectData) {
        _viewState.value = GithubProjectListViewState.Success(githubProjectData = githubProjectData)
    }
}