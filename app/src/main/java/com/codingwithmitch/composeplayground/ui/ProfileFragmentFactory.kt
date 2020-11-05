package com.codingwithmitch.composeplayground.ui

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.composeplayground.ui.avatar.AvatarFragment

class ProfileFragmentFactory
constructor(
    private val viewModelFactory: ViewModelProvider.Factory
): FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when (className) {

            AvatarFragment::class.java.name -> {
                AvatarFragment(viewModelFactory)
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }
}