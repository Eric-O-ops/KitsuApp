package com.example.kitsuapperic.data.remote.apiservices

import com.example.kitsuapperic.models.auth.AuthModel
import com.example.kitsuapperic.models.auth.TokenModel
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {

    @POST("oauth/token")
    suspend fun postAuthDataUser(
       @Body authModel: AuthModel):TokenModel
}
