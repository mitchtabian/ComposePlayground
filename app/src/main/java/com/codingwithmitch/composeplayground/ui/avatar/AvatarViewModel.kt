package com.codingwithmitch.composeplayground.ui.avatar

import androidx.compose.ui.graphics.ImageAsset
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AvatarViewModel: ViewModel() {

    private val _avatarUriPath: MutableLiveData<String> = MutableLiveData()
    val avatarUriPath: LiveData<String> = _avatarUriPath

//    private val _avatarAsset: MutableLiveData<ImageAsset> = MutableLiveData()
//    val avatarAsset: LiveData<ImageAsset> = _avatarAsset

    private val _snackbarMessage = MutableLiveData("")
    val snackbarMessage: LiveData<String> = _snackbarMessage


    fun onAvatarChanged(path: String){
        _avatarUriPath.value = path
    }

    fun setSnackbarMessage(message: String?){
        _snackbarMessage.value = message
    }



}













