package com.codingwithmitch.composeplayground.ui.name

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
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
fun NameCaptureScreen(
    navController: NavController,
    viewModel: NameViewModel,
    uiController: UIController
) {

    // Requires: import androidx.compose.runtime.getValue
    val name: String by viewModel.name.observeAsState("")

    val snackbarMessage: String by viewModel.snackbarMessage.observeAsState("")

    Log.d(TAG, "NameCaptureScreen: VIEWMODEL: ${viewModel}")

    Column{
        InputName(
            name = name,
            onNameChanged = {
                viewModel.onNameChanged(it)
            }
        )
        NextBtn {
            val isValid = viewModel.isFormValid()
            when(isValid){
                is FormValidation.Valid -> {
                    navController.navigate(R.id.action_nameFragment_to_emailFragment)
                }

                is FormValidation.Invalid -> {
                    viewModel.setSnackbarMessage(isValid.message)
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
}


@Composable
fun InputName(
    name: String,
    onNameChanged: (String) -> Unit
){
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TextField(
                value = name,
                onValueChange = {onNameChanged(it)},
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth(),
                keyboardType = KeyboardType.Text
        )

    }
}