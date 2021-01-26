package com.codingwithmitch.composeplayground.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment

class MainFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val show = remember { mutableStateOf(true)}

                Box(modifier = Modifier.fillMaxSize()){
                    if(show.value){
                        AlertDialog(
                            onDismissRequest = {
                                show.value = false
                            },
                            title = { Text(text = "Some title",) },
                            text = { Text(text = "Some description",) },
                            buttons = {
                                Row(
                                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                                    horizontalArrangement = Arrangement.End,
                                ) {
                                    Button(
                                        modifier = Modifier.padding(end = 8.dp),
                                        onClick = {
                                            show.value = false
                                        },
                                    ) {
                                        Text(text = "Ok")
                                    }
                                }
                            },
                        )
                    }
                }
            }
        }
    }
}















