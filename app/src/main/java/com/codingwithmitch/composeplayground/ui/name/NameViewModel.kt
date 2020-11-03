package com.codingwithmitch.composeplayground.ui.name

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codingwithmitch.composeplayground.ui.util.FormValidation

class NameViewModel
constructor(
        private val someFakeDependency: String
): ViewModel() {

    private val TAG: String = "AppDebug"

    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _snackbarMessage = MutableLiveData("")
    val snackbarMessage: LiveData<String> = _snackbarMessage

    fun onNameChanged(newName: String) {
        _name.value = newName
    }

    fun setSnackbarMessage(message: String?){
        _snackbarMessage.value = message
    }

    init {
        Log.d(TAG, "Do nothing: ${someFakeDependency}")
    }

    fun isFormValid(): FormValidation {
        if(_name.value.isNullOrBlank()){
            return FormValidation.Invalid("Invalid name.")
        }
        return FormValidation.Valid()
    }

}

















