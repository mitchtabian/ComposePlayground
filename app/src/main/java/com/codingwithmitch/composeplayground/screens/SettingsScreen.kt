package com.codingwithmitch.composeplayground.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(){

    Column() {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Settings",
            style = MaterialTheme.typography.h4
        )
    }
}