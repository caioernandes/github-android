package com.caioernandes.githubandroid.base

import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before

internal open class InstrumentedTest {

    val server = MockWebServer()

    private val serverPort = 8080

    @Before
    fun setUp() {
        server.start(serverPort)
    }

    @After
    fun tearDown() {
        server.close()
    }
}
