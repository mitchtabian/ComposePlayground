package com.codingwithmitch.composeplayground.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            InputCaptureScreen ()
        }

    }
}

class InputCaptureViewModel: ViewModel() {

    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    fun onNameChanged(newName: String) {
        _name.value = newName
    }
}

@Composable
fun InputCaptureScreen(
    viewModel: InputCaptureViewModel = viewModel()
) {

    // Requires: import androidx.compose.runtime.getValue
    val name: String by viewModel.name.observeAsState("")

    MaterialTheme{
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            TextField(
                value = name,
                onValueChange = {viewModel.onNameChanged(it)},
                label = { Text("Name")},
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                name,
                style = typography.h3,
                modifier = Modifier
                    .padding(top = 20.dp)
            )
        }
    }
}


@Preview
@Composable
fun Preview() {
    InputCaptureScreen()
}











