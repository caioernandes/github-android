package com.caioernandes.githubandroid.features.githubprojectlist.domain.model

data class GithubProjectData(
    val incompleteResults: Boolean,
    val items: List<Item>,
    val totalCount: Int
)
