@file:OptIn(ExperimentalCoroutinesApi::class)

package com.caioernandes.githubandroid.githubprojectlist.presentation

import androidx.test.filters.LargeTest
import com.caioernandes.githubandroid.base.InstrumentedTest
import com.caioernandes.githubandroid.extensions.launchFragment
import com.caioernandes.githubandroid.features.githubprojectlist.presentation.GithubProjectListFragment
import com.caioernandes.githubandroid.githubprojectlist.robot.GithubProjectListActionRobot
import com.caioernandes.githubandroid.githubprojectlist.robot.GithubProjectListArrangeRobot
import com.caioernandes.githubandroid.githubprojectlist.robot.GithubProjectListAssertRobot
import com.caioernandes.githubandroid.helpers.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@LargeTest
internal class GithubProjectListActivityTest : InstrumentedTest() {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private val arrangeRobot by lazy { GithubProjectListArrangeRobot(server) }

    private val actionRobot by lazy { GithubProjectListActionRobot() }

    private val assertRobot by lazy { GithubProjectListAssertRobot() }

    @Test
    fun checkFirstItemIsVisible() = runTest {
        arrangeRobot {
            mockGithubProjectListNetworkResponse()
            launchFragment<GithubProjectListFragment>()
        }
        actionRobot {
            scrollToItemList(position = 1)
        }
        assertRobot {
            githubProjectListIsVisible()
        }
    }
}