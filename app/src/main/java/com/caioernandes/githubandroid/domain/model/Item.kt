package com.caioernandes.githubandroid.domain.model

data class Item(
    val name: String,
    val forksCount: Int,
    val stargazersCount: Int,
    val owner: Owner
)
