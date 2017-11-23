package com.example.poclib.test

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.nio.charset.Charset
import java.util.logging.LogRecord
import java.util.logging.Logger

/**
 * Created on 21.11.17.
 */

internal class LoggingInterceptor : Interceptor {

    var token: String = "tteks28645dje755ppoHHYJ963.0175UNNOior;nv69"

    override fun intercept(chain: Interceptor.Chain?): Response {
        var request : Request = chain!!.request()

        //authentification header
        var authenticateRequest = request.newBuilder()
                .header("Authentification",token)
                .build()

        val logger = Logger.getLogger(LoggingInterceptor::class.simpleName)

        //display request headers
        logger.info("Authentification : ".plus(token))

        val t1 : Long = System.nanoTime()
        logger.info(String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()))


        var response : Response = chain.proceed(request)
        val t2 : Long = System.nanoTime()
        logger.info(String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6, response.headers()))

//raw JSon
        val responseBody = response.body()
        val source = responseBody!!.source()
        source.request(java.lang.Long.MAX_VALUE) // Buffer the entire body.
        val buffer = source.buffer()
        logger.info(buffer.clone().readString(Charset.forName("UTF-8")).toString())

        //add header
        chain.proceed(authenticateRequest)

        return response
    }
}