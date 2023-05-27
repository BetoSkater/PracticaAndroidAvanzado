package com.albertojr.practicaandroidavanzado

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

class DragonBallApiMockDispatcher : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            //Login path
            "/api/auth/login" -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                        //Login call needs a header
                    .setHeader("Authorization", "Basic XdFa12313SSDASdewfawn2DFASD")
                        //This call has no body, but, where do I give the token back?
                    .setBody("EcFasF4554as.XCasjqASD138u2323.ADAWFGGAç58WDA5.12314SASADAWDA ")
                    //TODO the real call doesn't have a body

            }

            else -> MockResponse().throttleBody(1024, 5, TimeUnit.SECONDS)
        }
    }
}