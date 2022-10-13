package com.caioernandes.githubandroid.features.githubprojectlist.presentation

import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.GithubProjectData
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.Item
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.Owner

object GithubProjectListStub {

    val resultSuccess = GithubProjectData(
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
}