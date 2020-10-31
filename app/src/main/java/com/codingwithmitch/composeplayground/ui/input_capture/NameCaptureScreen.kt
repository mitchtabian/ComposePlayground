package com.codingwithmitch.composeplayground.ui.input_capture

import android.util.Log
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.navigation.compose.navigate
import androidx.navigation.NavHostController

private val TAG: String = "AppDebug"

@Composable
fun NameCaptureScreen(
    navController: NavHostController,
    viewModel: InputCaptureViewModel = viewModel()
) {

    // Requires: import androidx.compose.runtime.getValue
    val name: String by viewModel.name.observeAsState("")

    Log.d(TAG, "NameCaptureScreen: VIEWMODEL: ${viewModel}")

    Column(

    ) {
        InputName(
            name = name,
            onNameChanged = {
                viewModel.onNameChanged(it)
            }
        )
        NextBtn {
            // import androidx.navigation.compose.navigate
            navController.navigate("email_capture_screen")
        }
    }

}

@Composable
fun NextBtn(
    onClickNext: () -> Unit
){
    Row(
        modifier =  Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ){
        Button(
            onClick = onClickNext,
            content = {
                Text(text = "Next")
            }
        )
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
            modifier = Modifier.fillMaxWidth()
        )

    }
}