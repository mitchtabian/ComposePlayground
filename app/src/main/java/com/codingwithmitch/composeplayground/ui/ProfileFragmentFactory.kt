package com.codingwithmitch.composeplayground.ui

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.composeplayground.ui.avatar.AvatarFragment
import com.codingwithmitch.composeplayground.ui.email.EmailFragment
import com.codingwithmitch.composeplayground.ui.name.NameFragment

class ProfileFragmentFactory
constructor(
    private val viewModelFactory: ViewModelProvider.Factory
): FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when (className) {
            NameFragment::class.java.name -> {
                NameFragment(viewModelFactory)
            }

            EmailFragment::class.java.name -> {
                EmailFragment(viewModelFactory)
            }

            AvatarFragment::class.java.name -> {
                AvatarFragment(viewModelFactory)
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }
}