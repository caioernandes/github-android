package com.caioernandes.githubandroid.features.githubprojectlist.presentation

import com.caioernandes.githubandroid.base.robot.BaseRobot
import com.caioernandes.githubandroid.R

fun check(func: GithubProjectListActivityAssertionRobot.() -> Unit) =
    GithubProjectListActivityAssertionRobot().apply { func() }

open class GithubProjectListActivityAssertionRobot : BaseRobot() {

    fun projectNameIsVisible(text: String) {
        checkViewHasText(R.id.projectName, text)
    }

    fun forksCountIsVisible(text: String) {
        checkViewHasText(R.id.forksCount, text)
    }

    fun stargazersCountIsVisible(text: String) {
        checkViewHasText(R.id.stargazersCount, text)
    }

    fun userNameIsVisible(text: String) {
        checkViewHasText(R.id.userName, text)
    }

    fun userAvatarIsVisible() {
        checkViewIsDisplayed(R.id.userAvatar)
    }
}