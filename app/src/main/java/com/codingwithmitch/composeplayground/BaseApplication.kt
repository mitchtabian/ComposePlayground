package com.codingwithmitch.composeplayground

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.composeplayground.ui.MainActivity
import com.codingwithmitch.composeplayground.ui.ProfileFragmentFactory
import com.codingwithmitch.composeplayground.ui.ProfileViewModelFactory
import com.codingwithmitch.composeplayground.ui.UIController

class BaseApplication : Application(){

    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var fragmentFactory: ProfileFragmentFactory

    fun init(){
        initVMFactory()
        initFragmentFactory()
    }

    private fun initVMFactory(){
        if(!::viewModelFactory.isInitialized){
            viewModelFactory = ProfileViewModelFactory(
                someFakeDependency = "Just a placeholder for a real dependency."
            )
        }
    }

    private fun initFragmentFactory(){
        if(!::fragmentFactory.isInitialized) {
            if (::viewModelFactory.isInitialized) {
                fragmentFactory = ProfileFragmentFactory(viewModelFactory)
            }
        }
    }

}