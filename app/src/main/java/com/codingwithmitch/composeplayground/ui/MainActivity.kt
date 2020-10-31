package com.codingwithmitch.composeplayground.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.viewinterop.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codingwithmitch.composeplayground.ui.input_capture.EmailCaptureScreen
import com.codingwithmitch.composeplayground.ui.input_capture.InputCaptureViewModel
import com.codingwithmitch.composeplayground.ui.input_capture.NameCaptureScreen


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                val viewModel: InputCaptureViewModel = viewModel()
                NavHost(
                        navController,
                        startDestination = "name_capture_screen"
                ) {
                    composable("name_capture_screen") { NameCaptureScreen(navController, viewModel)}
                    composable("email_capture_screen") { EmailCaptureScreen(viewModel) }
                }
            }
        }

    }
}




//@Preview
//@Composable
//fun Preview() {
//    InputCaptureScreen()
//}











