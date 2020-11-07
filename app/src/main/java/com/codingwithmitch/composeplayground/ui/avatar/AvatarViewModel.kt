package com.codingwithmitch.composeplayground.ui.avatar

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


private val TAG: String = "AppDebug"

class AvatarViewModel: ViewModel() {

    private val _uri: MutableLiveData<UriHolder> = MutableLiveData()
    val uri: LiveData<UriHolder> =  _uri

    private val _snackbarMessage = MutableLiveData("")
    val snackbarMessage: LiveData<String> = _snackbarMessage

    fun setSnackbarMessage(message: String?){
        _snackbarMessage.value = message
    }

    fun setUri(newUri: Uri){
        _uri.value = UriHolder(newUri)
    }

}

data class UriHolder(
        var uri: Uri? = null
)












