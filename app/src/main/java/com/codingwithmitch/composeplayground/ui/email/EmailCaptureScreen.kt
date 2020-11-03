package com.codingwithmitch.composeplayground.ui.email

import android.util.Log
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.codingwithmitch.composeplayground.R
import com.codingwithmitch.composeplayground.components.BasicSnackbarWithText
import com.codingwithmitch.composeplayground.components.NextBtn
import com.codingwithmitch.composeplayground.ui.UIController
import com.codingwithmitch.composeplayground.ui.util.FormValidation

private val TAG: String = "AppDebug"

@Composable
fun EmailCaptureScreen(
        navController: NavController,
        viewModel: EmailViewModel,
        uiController: UIController
) {

    val email: String by viewModel.email.observeAsState("")

    val snackbarMessage: String by viewModel.snackbarMessage.observeAsState("")

    Log.d(TAG, "EmailCaptureScreen: VIEWMODEL: ${viewModel}")

    Column() {
        InputEmail(
            email = email,
            onEmailChanged = {
                viewModel.onEmailChanged(it)
            }
        )
        NextBtn {
            val isValid = viewModel.isFormValid()
            when(isValid){
                is FormValidation.Valid -> {
                    navController.navigate(R.id.action_emailFragment_to_avatarFragment)
                }

                is FormValidation.Invalid -> {
                    viewModel.setSnackbarMessage(isValid.message)
                }
            }
        }
    }
    if(!snackbarMessage.isBlank()){
        uiController.hideKeyboard()
        BasicSnackbarWithText(
                snackbarMessage,
                2000,
                {viewModel.setSnackbarMessage("")}
        )
    }
}


@Composable
fun InputEmail(
    email: String,
    onEmailChanged: (String) -> Unit
){
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TextField(
                value = email,
                onValueChange = {onEmailChanged(it)},
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                keyboardType = KeyboardType.Email
        )

    }
}














