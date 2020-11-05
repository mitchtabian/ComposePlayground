package com.codingwithmitch.composeplayground.ui.avatar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AvatarViewModel: ViewModel() {

    private val _avatarUrl = MutableLiveData("")
    val avatarUrl: LiveData<String> = _avatarUrl

    private val _snackbarMessage = MutableLiveData("")
    val snackbarMessage: LiveData<String> = _snackbarMessage


    fun onAvatarChanged(newUrl: String){
        _avatarUrl.value = newUrl
    }

    fun setSnackbarMessage(message: String?){
        _snackbarMessage.value = message
    }



}













