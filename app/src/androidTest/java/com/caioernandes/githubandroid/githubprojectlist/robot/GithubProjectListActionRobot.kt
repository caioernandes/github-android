package com.caioernandes.githubandroid.githubprojectlist.robot

import com.caioernandes.githubandroid.base.robot.ActionRobot
import com.caioernandes.githubandroid.features.githubprojectlist.presentation.adapter.GithubProjectListAdapter
import com.caioernandes.githubandroid.R

internal class GithubProjectListActionRobot : ActionRobot() {

    operator fun invoke(func: GithubProjectListActionRobot.() -> Unit) =
        GithubProjectListActionRobot().apply { func() }

    fun scrollToItemList(position: Int) {
        recyclerViewScrollToItemPosition<GithubProjectListAdapter.GithubProjectViewHolder>(
            R.id.githubProjectListRecyclerView,
            position
        )
    }
}