@file:OptIn(ExperimentalCoroutinesApi::class)

package com.caioernandes.githubandroid.features.githubprojectlist.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.GithubProjectData
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.Item
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.Owner
import com.caioernandes.githubandroid.features.githubprojectlist.domain.usecase.GetGithubProjectListUseCase
import com.caioernandes.githubandroid.utils.MainCoroutineRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@SmallTest
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
    fun `on get github project list returns success should call useCase once`() = runTest {
        // Given
        val page = 1
        getGithubProjectListUseCaseMockSuccess()

        // When
        viewModel.onGetGithubProjectList()

        // Then
        coVerify(exactly = 0) { getGithubProjectListUseCase.invoke(page = page) }
    }

    @Test
    fun `on get github project list returns error should call useCase once`() = runTest {
        // Given
        val page = 1
        getGithubProjectListUseCaseMockError()

        // When
        viewModel.onGetGithubProjectList()

        // Then
        coVerify(exactly = 0) { getGithubProjectListUseCase.invoke(page = page) }
    }

    private fun getGithubProjectListUseCaseMockSuccess(page: Int = 1) {
        coEvery {
            getGithubProjectListUseCase(page = page)
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

    private fun getGithubProjectListUseCaseMockError(page: Int = 1) {
        coEvery {
            getGithubProjectListUseCase(page = page)
        } returns flow { throw InterruptedException() }
    }

    private fun createViewModel() {
        viewModel = GithubProjectListViewModel(
            getGithubProjectListUseCase = getGithubProjectListUseCase
        )
    }
}