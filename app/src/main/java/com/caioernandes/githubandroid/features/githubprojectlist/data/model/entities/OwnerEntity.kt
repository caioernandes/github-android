package com.caioernandes.githubandroid.features.githubprojectlist.data.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OwnerEntity(
    @PrimaryKey val idUser: Long = 0,
    var idPullRequest: Long = 0,
    val login: String = "",
    val avatarUrl: String = ""
)