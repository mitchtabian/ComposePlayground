package com.codingwithmitch.composeplayground.ui.email

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codingwithmitch.composeplayground.ui.util.FormValidation

class EmailViewModel: ViewModel() {

    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email

    private val _snackbarMessage = MutableLiveData("")
    val snackbarMessage: LiveData<String> = _snackbarMessage

    fun onEmailChanged(newEmail: String){
        _email.value = newEmail
    }

    fun setSnackbarMessage(message: String?){
        _snackbarMessage.value = message
    }

    fun isFormValid(): FormValidation {
        val email = _email.value
        if(email.isNullOrBlank()){
            return FormValidation.Invalid("Invalid email.")
        }
        if(!email.contains("@")){
            return FormValidation.Invalid("An email must contain an '@' symbol.")
        }
        return FormValidation.Valid()
    }

}