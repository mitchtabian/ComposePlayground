package com.codingwithmitch.composeplayground.ui

import androidx.compose.ui.graphics.ImageAsset
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.composeplayground.ui.avatar.AvatarViewModel

class ProfileViewModelFactory
constructor(
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {

            AvatarViewModel::class.java -> {
                AvatarViewModel() as T
            }

            else -> {
                throw IllegalArgumentException("unknown model class $modelClass")
            }
        }
    }
}