@file:OptIn(ExperimentalCoroutinesApi::class)

package com.caioernandes.githubandroid.features.githubprojectlist.presentation

import com.caioernandes.githubandroid.helpers.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

internal class GithubProjectListActivityTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @Test
    fun checkFirstItemIsVisible() {
        onActivity {
            setUpMockServer()
            launch()
        }
        check {
            projectNameIsVisible(text = "okhttp")
            forksCountIsVisible(text = "8945")
            stargazersCountIsVisible(text = "42995")
            userNameIsVisible(text = "square")
            userAvatarIsVisible()
        }
    }
}