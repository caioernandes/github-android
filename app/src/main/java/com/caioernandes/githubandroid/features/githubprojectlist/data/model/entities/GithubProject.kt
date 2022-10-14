package com.caioernandes.githubandroid.features.githubprojectlist.data.model.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class GithubProject(
    @PrimaryKey val id: Long = 0,
    var resultDataId: String = UUID.randomUUID().toString(),
    val name: String = "",
    @Embedded val owner: OwnerEntity? = OwnerEntity(),
    val forksCount: Int = 0,
    val stargazersCount: Int = 0
)