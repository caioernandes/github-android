package com.caioernandes.githubandroid.features.githubprojectlist.data.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class ResultGithubDataEntity (
	@PrimaryKey val id: String = UUID.randomUUID().toString(),
	val totalCount : Int = 0,
	val incompleteResults : Boolean = false
)