package com.caioernandes.githubandroid.githubprojectlist.robot

import com.caioernandes.githubandroid.base.robot.ArrangeRobot
import com.caioernandes.githubandroid.helpers.ConstantsJsonResponse
import okhttp3.mockwebserver.MockWebServer

private const val GITHUB_PROJECT_LIST_ENDPOINT_PATH =
    "/search/repositories?q=language:kotlin&sort=starts&page=1"

internal class GithubProjectListArrangeRobot(private val server: MockWebServer) :
    ArrangeRobot(server) {

    operator fun invoke(func: GithubProjectListArrangeRobot.() -> Unit) =
        GithubProjectListArrangeRobot(server).apply { func() }

    fun mockGithubProjectListNetworkResponse() {
        mockNetworkResponse(
            path = GITHUB_PROJECT_LIST_ENDPOINT_PATH,
            bodyResponseSuccess = ConstantsJsonResponse.githubProjectListResponse
        )
    }
}

