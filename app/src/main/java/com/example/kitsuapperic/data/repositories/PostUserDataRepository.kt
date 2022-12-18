package com.example.kitsuapperic.data.repositories

import com.example.kitsuapperic.base.BaseRepository
import com.example.kitsuapperic.data.remote.apiservices.SignInApiService
import com.example.kitsuapperic.models.auth.AuthModel
import javax.inject.Inject

class PostUserDataRepository @Inject constructor(
    private val api: SignInApiService
): BaseRepository() {
    fun postUserData(authModel: AuthModel) = doRequest {
        api.postAuthDataUser(authModel)
    }
}