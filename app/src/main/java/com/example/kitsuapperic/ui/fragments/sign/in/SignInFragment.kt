package com.example.kitsuapperic.ui.fragments.sign.`in`

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapperic.R
import com.example.kitsuapperic.base.BaseFragment
import com.example.kitsuapperic.data.locale.preferences.userdata.UserPreferencesData
import com.example.kitsuapperic.databinding.FragmentSignInBinding
import com.example.kitsuapperic.models.auth.AuthModel
import com.example.kitsuapperic.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment :
    BaseFragment<FragmentSignInBinding, SignInViewModel>(R.layout.fragment_sign_in) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    override val binding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels()

    override fun setupSubscribes() = with(binding) {

        binding.signInBottom.setOnClickListener {
            val email = enterName.text.toString()
            val password = enterPassword.text.toString()
            val authModel = AuthModel("password", email, password)

            viewModel.postUserData(authModel).subscribe(
                onError = {
                    Log.e("TAG", "setupSubscribes: $it")

                },
                onSuccess = { token ->
                    toast("$token")
                    if (token != null) {
                        userPreferencesData.apply {
                            isAuthorized = true
                            accessToken = token.accessToken
                            refreshToken = token.refreshToken
                        }

                        findNavController().navigate(
                            R.id.mainFragment
                        )
                    }
                }
            )
        }
    }
}