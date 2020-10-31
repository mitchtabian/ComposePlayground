package com.codingwithmitch.composeplayground.ui.input_capture

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel

@Composable
fun InputCaptureScreen(
    viewModel: InputCaptureViewModel = viewModel()
) {

    // Requires: import androidx.compose.runtime.getValue
    val name: String by viewModel.name.observeAsState("")

    MaterialTheme{
        InputName(
                name = name,
                onNameChanged = {
                    viewModel.onNameChanged(it)
                }
        )
    }
}

//@Composable
//fun NextBtn(
//
//){
//    Button(
//            onClick = {},
//            content = {
//                Text(text = "Go")
//            }
//    )
//}

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
        Text(
            name,
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .padding(top = 20.dp)
        )
    }
}