package com.codingwithmitch.composeplayground.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.codingwithmitch.composeplayground.TAG
import com.codingwithmitch.composeplayground.screens.home.home1.HomeViewModel1
import com.codingwithmitch.composeplayground.screens.home.home2.HomeViewModel2

@Composable
fun HomeScreen2(
    navController: NavController,
    navBackStackEntry: NavBackStackEntry,
){
    val viewModel: HomeViewModel2 = viewModel(HomeViewModel2::class.java, "HomeViewModel2")
//    val factory = navController.currentBackStackEntry?.let {
//        HiltViewModelFactory(AmbientContext.current, it)
//    }
//    val viewModel = viewModel<HomeViewModel>(factory = factory)
//    val factory = HiltViewModelFactory(AmbientContext.current, navBackStackEntry)
//    val viewModel: HomeViewModel2 = viewModel(HomeViewModel2::class.java,"HomeViewModel2", factory)
    Log.d(TAG, "HomeScreen2: ${viewModel}")
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
        Button(
            modifier = Modifier
                .padding(8.dp)
            ,
            onClick = { navController.navigate("home3")}
        ) {
            Text(text = "Go Home3")
        }
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





















