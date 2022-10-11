package com.caioernandes.githubandroid.features.githubprojectlist.domain.model

data class Item(
    val name: String,
    val forksCount: Int,
    val stargazersCount: Int,
    val owner: Owner
)
