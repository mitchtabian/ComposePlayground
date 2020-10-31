package com.codingwithmitch.composeplayground.ui.input_capture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InputCaptureViewModel: ViewModel() {

    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _email = MutableLiveData("")
    val email: LiveData<String> = _email

    fun onNameChanged(newName: String) {
        _name.value = newName
    }

    fun onEmailChanged(newEmail: String){
        _email.value = newEmail
    }
}