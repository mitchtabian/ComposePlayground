package com.codingwithmitch.composeplayground.ui.avatar

import android.net.Uri
import android.os.Parcelable
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.parcel.Parcelize


private val TAG: String = "AppDebug"

class AvatarViewModel: ViewModel() {

    var uriHolder: UriHolder by mutableStateOf(UriHolder())
        private set

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

    fun setUriHolder(newUri: Uri){
        val currentHolder = uriHolder
        if(currentHolder.uri == null){
            currentHolder.uri = newUri
            uriHolder = currentHolder
        }
        else{
            if((currentHolder.uri as Uri) != newUri){
                currentHolder.uri = newUri
                uriHolder = currentHolder
            }
        }
    }

}

@Parcelize
data class UriHolder(
        var uri: Uri? = null
) : Parcelable {

}










