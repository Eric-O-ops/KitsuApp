package com.example.kitsuapperic.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.kitsuapperic.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(@LayoutRes idLayout: Int) :
    Fragment(idLayout) {

    protected abstract val binding: VB
    protected abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        setupSubscribes()
    }

    protected open fun initialize() {}

    protected open fun setupListener() {}

    protected open fun setupSubscribes() {}

    protected open fun <T> Flow<Resource<T>>.subscribe(
        state: ((state: Resource<T>) -> Unit)? = null,
        onError: (error: String) -> Unit,
        onSuccess: ((data: T) -> Unit),
    ) {
        lifecycleScope.launch {
            collect {
                when (it) {
                    is Resource.Error -> onError(it.message.toString())
                    is Resource.Loading -> {}
                    is Resource.Success -> {

                        it.data?.let { data ->
                            onSuccess(data)
                        }
                    }
                }
            }
        }
    }
}