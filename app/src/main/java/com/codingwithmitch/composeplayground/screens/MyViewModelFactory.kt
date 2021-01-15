package com.codingwithmitch.composeplayground.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.composeplayground.screens.home.HomeViewModel
import com.codingwithmitch.composeplayground.screens.profile.ProfileViewModel
import com.codingwithmitch.composeplayground.screens.settings.SettingsViewModel

class MyViewModelFactory: ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when(modelClass){
            HomeViewModel::class.java ->{
                HomeViewModel() as T
            }
            ProfileViewModel::class.java -> {
                 ProfileViewModel() as T
            }
            SettingsViewModel::class.java -> {
                SettingsViewModel() as T
            }
            else -> throw IllegalArgumentException("unknown model class $modelClass")
        }
    }
}