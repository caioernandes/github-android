package com.caioernandes.githubandroid.data.model

import com.google.gson.annotations.SerializedName

data class GithubProjectDataResponse(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean?,
    @SerializedName("items")
    val items: List<ItemResponse>?,
    @SerializedName("total_count")
    val totalCount: Int?
)