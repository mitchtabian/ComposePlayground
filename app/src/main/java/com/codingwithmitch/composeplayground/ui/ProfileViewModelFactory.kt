package com.codingwithmitch.composeplayground.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.composeplayground.ui.avatar.AvatarViewModel
import com.codingwithmitch.composeplayground.ui.email.EmailViewModel
import com.codingwithmitch.composeplayground.ui.name.NameViewModel

class ProfileViewModelFactory
constructor(
    val someFakeDependency: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {

            NameViewModel::class.java -> {
                NameViewModel(someFakeDependency) as T
            }

            EmailViewModel::class.java -> {
                EmailViewModel() as T
            }

            AvatarViewModel::class.java -> {
                AvatarViewModel() as T
            }

            else -> {
                throw IllegalArgumentException("unknown model class $modelClass")
            }
        }
    }
}