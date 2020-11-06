package com.codingwithmitch.composeplayground.ui.avatar

import android.net.Uri
import androidx.compose.ui.graphics.ImageAsset
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AvatarViewModel: ViewModel() {

    private val _uri: MutableLiveData<UriHolder> = MutableLiveData(UriHolder(null))
    val uri: LiveData<UriHolder> =  _uri

    private val _snackbarMessage = MutableLiveData("")
    val snackbarMessage: LiveData<String> = _snackbarMessage

    fun setSnackbarMessage(message: String?){
        _snackbarMessage.value = message
    }

    fun setUri(uri: Uri){
        _uri.value = UriHolder(uri)
    }

}


data class UriHolder(
        var uri: Uri? = null
)










