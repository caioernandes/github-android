package com.caioernandes.githubandroid.features.githubprojectlist.presentation

import android.content.Intent
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider
import com.caioernandes.githubandroid.helpers.ConstantsJsonResponse
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest

private const val SERVER_PORT = 8080

fun onActivity(func: GithubProjectListActivityRobot.() -> Unit) =
    GithubProjectListActivityRobot().apply { func() }

class GithubProjectListActivityRobot : GithubProjectListActivityAssertionRobot() {

    private val server = MockWebServer()

    fun setUpMockServer() {
        server.start(SERVER_PORT)

        server.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return when (request.path) {
                    "/search/repositories?q=language:kotlin&sort=starts&page=1" -> successResponse
                    else -> errorResponse
                }
            }
        }
    }

    fun launch() {
        val intent = Intent(
            ApplicationProvider.getApplicationContext(),
            GithubProjectListActivity::class.java
        )
        rule.launch(intent)
    }

    companion object {

        private val successResponse by lazy {
            MockResponse()
                .setResponseCode(200)
                .setBody(ConstantsJsonResponse.githubProjectListResponse)
        }

        private val errorResponse by lazy { MockResponse().setResponseCode(503) }
    }
}
