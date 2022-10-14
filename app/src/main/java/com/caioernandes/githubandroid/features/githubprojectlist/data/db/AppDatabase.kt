package com.caioernandes.githubandroid.features.githubprojectlist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.caioernandes.githubandroid.BuildConfig
import com.caioernandes.githubandroid.features.githubprojectlist.data.dao.GithubProjectListDao
import com.caioernandes.githubandroid.features.githubprojectlist.data.model.entities.GithubProject
import com.caioernandes.githubandroid.features.githubprojectlist.data.model.entities.ResultGithubDataEntity

@Database(
    entities = [GithubProject::class, ResultGithubDataEntity::class],
    version = BuildConfig.VERSION_CODE,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun githubProjectListDao(): GithubProjectListDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { appDatabase ->
                    instance = appDatabase
                }
            }

        private fun buildDatabase(appContext: Context): AppDatabase {
            return Room.databaseBuilder(appContext, AppDatabase::class.java, "github.db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}