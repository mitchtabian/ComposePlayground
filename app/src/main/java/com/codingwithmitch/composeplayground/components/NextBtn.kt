package com.codingwithmitch.composeplayground.components

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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