package com.codingwithmitch.composeplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientViewModelStoreOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.codingwithmitch.composeplayground.screens.MyViewModelFactory
import com.codingwithmitch.composeplayground.screens.createViewModel
import com.codingwithmitch.composeplayground.screens.profile.ProfileViewModel

@Composable
fun ProfileScreen(){
    val vmStore = AmbientViewModelStoreOwner.current.viewModelStore
    val viewModel: ProfileViewModel = remember {
        createViewModel(
            viewModelClass = ProfileViewModel::class,
            storeProducer = {vmStore},
            factory = MyViewModelFactory()
        )
    }
    Column() {
        Text(
            modifier = Modifier.padding(16.dp),
            text = viewModel.name.value,
            style = MaterialTheme.typography.h4
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .padding(8.dp)
            ,
            value = viewModel.name.value,
            onValueChange = {
                viewModel.name.value = it
            },
            label = {
                Text(text = "Enter your name")
            },
            textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
            backgroundColor = MaterialTheme.colors.surface
        )
    }
}