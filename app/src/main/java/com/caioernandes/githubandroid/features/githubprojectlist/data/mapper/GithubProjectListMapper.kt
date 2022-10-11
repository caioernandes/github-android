package com.caioernandes.githubandroid.features.githubprojectlist.data.mapper

import com.caioernandes.common.extensions.orFalse
import com.caioernandes.common.extensions.orZero
import com.caioernandes.githubandroid.features.githubprojectlist.data.model.GithubProjectDataResponse
import com.caioernandes.githubandroid.features.githubprojectlist.data.model.ItemResponse
import com.caioernandes.githubandroid.features.githubprojectlist.data.model.OwnerResponse
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.GithubProjectData
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.Item
import com.caioernandes.githubandroid.features.githubprojectlist.domain.model.Owner

fun GithubProjectDataResponse.toDomain() = GithubProjectData(
    incompleteResults = incompleteResults.orFalse(),
    items = items?.toListItemDomain().orEmpty(),
    totalCount = totalCount.orZero()
)

private fun List<ItemResponse>?.toListItemDomain() = this?.map { it.toItemDomain() }

private fun ItemResponse.toItemDomain() = Item(
    name = name.orEmpty(),
    forksCount = forksCount.orZero(),
    stargazersCount = stargazersCount.orZero(),
    owner = owner?.toOwnerDomain() ?: Owner(login = String(), avatarUrl = String())
)

private fun OwnerResponse.toOwnerDomain() = Owner(
    login = login.orEmpty(),
    avatarUrl = avatarUrl.orEmpty()
)