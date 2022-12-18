package com.example.kitsuapperic.ui.fragments.sign.`in`

import androidx.lifecycle.ViewModel
import com.example.kitsuapperic.data.repositories.PostUserDataRepository
import com.example.kitsuapperic.models.auth.AuthModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: PostUserDataRepository
): ViewModel() {

    fun postUserData(authModel: AuthModel) = repository.postUserData(authModel)
}