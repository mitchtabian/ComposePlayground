package com.codingwithmitch.composeplayground.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.composeplayground.screens.home.home1.HomeViewModel1
import com.codingwithmitch.composeplayground.screens.profile.profile1.ProfileViewModel1
import com.codingwithmitch.composeplayground.screens.settings.SettingsViewModel

class MyViewModelFactory: ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when(modelClass){
            HomeViewModel1::class.java ->{
                HomeViewModel1() as T
            }
            ProfileViewModel1::class.java -> {
                 ProfileViewModel1() as T
            }
            SettingsViewModel::class.java -> {
                SettingsViewModel() as T
            }
            else -> throw IllegalArgumentException("unknown model class $modelClass")
        }
    }
}