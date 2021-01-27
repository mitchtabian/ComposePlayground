package com.codingwithmitch.composeplayground.screens.home

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
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.codingwithmitch.composeplayground.screens.home.home3.HomeViewModel3

@Composable
fun HomeScreen3(
    navController: NavController
){
    val viewModel: HomeViewModel3 = viewModel(HomeViewModel3::class.java, "HomeViewModel3")
//    val factory = navController.currentBackStackEntry?.let {
//        HiltViewModelFactory(AmbientContext.current, it)
//    }
//    val viewModel = viewModel<HomeViewModel>(factory = factory)
    Column() {
        Text(
            modifier = Modifier.padding(16.dp),
            text = viewModel.text.value,
            style = MaterialTheme.typography.h4
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .padding(8.dp)
            ,
            value = viewModel.query.value,
            onValueChange = {
                viewModel.query.value = it
            },
            label = {
                Text(text = "Enter some text")
            },
            textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
            backgroundColor = MaterialTheme.colors.surface
        )
        Text(
            modifier = Modifier
                .padding(8.dp)
            ,
            text = "This is the end")
    }

//    navController.currentBackStackEntry?.let { backStackEntry ->
//        val viewModel: HomeViewModel = viewModel(HomeViewModel::class.java, "HomeViewModel")
//        Column() {
//            Text(
//                modifier = Modifier.padding(16.dp),
//                text = viewModel.text.value,
//                style = MaterialTheme.typography.h4
//            )
//            TextField(
//                modifier = Modifier
//                    .fillMaxWidth(.9f)
//                    .padding(8.dp)
//                ,
//                value = viewModel.query.value,
//                onValueChange = {
//                    viewModel.query.value = it
//                },
//                label = {
//                    Text(text = "Enter some text")
//                },
//                textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
//                backgroundColor = MaterialTheme.colors.surface
//            )
//        }
//    }
}





















