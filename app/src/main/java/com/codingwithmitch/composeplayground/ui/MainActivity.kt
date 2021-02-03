package com.codingwithmitch.composeplayground.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val query = remember { mutableStateOf("") }

            Column(modifier = Modifier.fillMaxWidth()) {
                TextField(
                        modifier = Modifier.padding(16.dp),
                        value = query.value,
                        onValueChange = {
                            query.value = it
                        },
                        keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Search,
                        ),
                        onImeActionPerformed = { action, softKeyboardController ->
                            if (action == ImeAction.Search) {
                                softKeyboardController?.hideSoftwareKeyboard()
                            }
                        },
                )
                Button(
                        onClick = { query.value = "Chicken" },
                        modifier = Modifier.padding(16.dp)
                ) {
                    Text("Trigger issue")
                }
            }
        }

    }
}













