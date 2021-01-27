package com.codingwithmitch.composeplayground.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.codingwithmitch.composeplayground.screens.profile.profile1.ProfileViewModel1

@Composable
fun ProfileScreen1(
    navController: NavController
){
    val viewModel: ProfileViewModel1 = viewModel(
        ProfileViewModel1::class.java, "ProfileViewModel1",
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
        Button(
            modifier = Modifier
                .padding(8.dp)
            ,
            onClick = { navController.navigate("profile2")}
        ) {
            Text(text = "Go Profile2")
        }
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