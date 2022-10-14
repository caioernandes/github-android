package com.caioernandes.githubandroid.features.githubprojectlist.data.model.entities

import androidx.room.Embedded
import androidx.room.Relation

data class ResultGithubDataWithGithubProject(
    @Embedded val resultGithubDataEntity: ResultGithubDataEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "resultDataId"
    )
    val githubProject: List<GithubProject>
)