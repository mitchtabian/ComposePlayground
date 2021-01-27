package com.codingwithmitch.composeplayground.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.codingwithmitch.composeplayground.screens.profile.profile2.ProfileViewModel2

@Composable
fun ProfileScreen2(){
    val viewModel: ProfileViewModel2 = viewModel(
        ProfileViewModel2::class.java, "ProfileViewModel2",
    )
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

//    navController.currentBackStackEntry?.let { backStackEntry ->
//        val viewModel: ProfileViewModel = viewModel(
//            ProfileViewModel::class.java, "ProfileViewModel", HiltViewModelFactory(
//                AmbientContext.current, backStackEntry
//            )
//        )
//        Column() {
//            Text(
//                modifier = Modifier.padding(16.dp),
//                text = viewModel.name.value,
//                style = MaterialTheme.typography.h4
//            )
//            TextField(
//                modifier = Modifier
//                    .fillMaxWidth(.9f)
//                    .padding(8.dp)
//                ,
//                value = viewModel.name.value,
//                onValueChange = {
//                    viewModel.name.value = it
//                },
//                label = {
//                    Text(text = "Enter your name")
//                },
//                textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
//                backgroundColor = MaterialTheme.colors.surface
//            )
//        }
//    }

}