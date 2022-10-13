package com.caioernandes.githubandroid.githubprojectlist.robot

import com.caioernandes.githubandroid.base.robot.AssertRobot
import com.caioernandes.githubandroid.R

internal class GithubProjectListAssertRobot : AssertRobot() {

    operator fun invoke(func: GithubProjectListAssertRobot.() -> Unit) =
        GithubProjectListAssertRobot().apply { func() }

    fun githubProjectListIsVisible() {
        viewIsVisible(R.id.githubProjectListRecyclerView)
    }
}