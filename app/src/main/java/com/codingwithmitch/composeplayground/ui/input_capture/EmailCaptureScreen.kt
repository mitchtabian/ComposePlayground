package com.codingwithmitch.composeplayground.ui.input_capture

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.navigation.NavHostController

private val TAG: String = "AppDebug"

@Composable
fun EmailCaptureScreen(
    navHostController: NavHostController,
    viewModel: InputCaptureViewModel = viewModel()
) {

    val email: String by viewModel.email.observeAsState("")

    Log.d(TAG, "NameCaptureScreen: VIEWMODEL: ${viewModel}")

    Column() {
        InputEmail(
            email = email,
            onEmailChanged = {
                viewModel.onEmailChanged(it)
            }
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
            modifier = Modifier.fillMaxWidth()
        )

    }
}