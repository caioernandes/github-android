@file:OptIn(ExperimentalCoroutinesApi::class)

package com.caioernandes.githubandroid.features.githubprojectlist.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.GithubProjectData
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.Item
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.Owner
import com.caioernandes.githubandroid.features.githubprojectlist.domain.usecase.GetGithubProjectListUseCase
import com.caioernandes.githubandroid.utils.MainCoroutineRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class GithubProjectListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private val getGithubProjectListUseCase: GetGithubProjectListUseCase = mockk(relaxed = true)

    private lateinit var viewModel: GithubProjectListViewModel

    @Before
    fun setUp() {
        createViewModel()
    }

    @Test
    fun `on get github project list should call useCase once`() = runTest {
        // Given
        getMovieListUseCaseMock()

        // When
        viewModel.onGetGithubProjectList()

        // Then
        coVerify(exactly = 0) { getGithubProjectListUseCase.invoke() }
    }

    private fun getMovieListUseCaseMock() {
        coEvery {
            getGithubProjectListUseCase()
        } returns flowOf(
            GithubProjectData(
                incompleteResults = false,
                items = listOf(
                    Item(
                        name = "name",
                        forksCount = "10",
                        stargazersCount = "12",
                        owner = Owner(login = "login", avatarUrl = "avatarUrl")
                    )
                ),
                totalCount = 10
            )
        )
    }

    private fun createViewModel() {
        viewModel = GithubProjectListViewModel(
            getGithubProjectListUseCase = getGithubProjectListUseCase
        )
    }
}