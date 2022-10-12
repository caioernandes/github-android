package com.caioernandes.githubandroid.features.githubprojectlist.presentation

import org.junit.Test

internal class GithubProjectListActivityTest {

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