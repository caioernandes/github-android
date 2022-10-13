package com.caioernandes.githubandroid.base.robot

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest

private const val HTTP_CODE_SUCCESS = 200
private const val HTTP_CODE_NOT_FOUND = 404

internal open class ArrangeRobot(private val server: MockWebServer) {

    fun mockNetworkResponse(
        path: String,
        bodyResponseSuccess: String,
        bodyResponseError: String? = null
    ) {
        server.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return when (request.path) {
                    path -> getSuccessResponse(body = bodyResponseSuccess)
                    else -> getErrorResponse(body = bodyResponseError)
                }
            }
        }
    }

    private fun getSuccessResponse(body: String): MockResponse {
        return MockResponse().setResponseCode(HTTP_CODE_SUCCESS).setBody(body)
    }

    private fun getErrorResponse(body: String? = null): MockResponse {
        return body?.let {
            MockResponse().setResponseCode(HTTP_CODE_NOT_FOUND).setBody(it)
        } ?: run {
            MockResponse().setResponseCode(HTTP_CODE_NOT_FOUND)
        }
    }
}