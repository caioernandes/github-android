package com.caioernandes.githubandroid.features.githubprojectlist.data.dao

import androidx.room.Dao
import androidx.room.Transaction
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.caioernandes.githubandroid.features.githubprojectlist.data.model.entities.GithubProject
import com.caioernandes.githubandroid.features.githubprojectlist.data.model.entities.ResultGithubDataEntity
import com.caioernandes.githubandroid.features.githubprojectlist.data.model.entities.ResultGithubDataWithGithubProject
import kotlinx.coroutines.flow.Flow

@Dao
interface GithubProjectListDao {

    @Transaction
    @Query("SELECT * FROM ResultGithubDataEntity")
    fun getAllGithubProjectList(): Flow<ResultGithubDataWithGithubProject>

    fun insertFullResultGithubData(
        resultData: ResultGithubDataEntity,
        repositoryListEntity: List<GithubProject>
    ) {
        insertResultGithubData(resultData)
        insertGithubProjectList(repositoryListEntity)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGithubProjectList(listRepository: List<GithubProject>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertResultGithubData(searchRepositoriesEntity: ResultGithubDataEntity)
}