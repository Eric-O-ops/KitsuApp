package com.example.kitsuapperic.data

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url =
            request.url.newBuilder()
                .addQueryParameter(
                    "Authorization",
                    "Bearer $"
                )
                .build()

        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}

