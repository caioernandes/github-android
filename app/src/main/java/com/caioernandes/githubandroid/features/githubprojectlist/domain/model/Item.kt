package com.caioernandes.githubandroid.features.githubprojectlist.domain.model

data class Item(
    val name: String,
    val forksCount: String,
    val stargazersCount: String,
    val owner: Owner
)
