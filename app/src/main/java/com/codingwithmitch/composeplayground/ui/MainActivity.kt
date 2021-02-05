package com.codingwithmitch.composeplayground.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {

    lateinit var connectionLiveData: ConnectionLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectionLiveData = ConnectionLiveData(this)
        setContent {
            val isNetworkAvailable = connectionLiveData.observeAsState(false).value
            ConnectivityMonitor(isNetworkAvailable = isNetworkAvailable)
        }
    }
}

@Composable
fun ConnectivityMonitor(
    isNetworkAvailable: Boolean,
){
    var connectionString = "Valid connection."
    if(!isNetworkAvailable){
        connectionString = "No network connection"
    }
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ){
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)){
                Text(
                    connectionString,
                    modifier = Modifier
                        .padding(8.dp),
                    style = MaterialTheme.typography.h4
                )
                if(isNetworkAvailable){
                    Icon(
                        Icons.Default.Check,
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.CenterVertically),
                        contentDescription = "Checkmark icon"
                    )
                }
                else{
                    Icon(
                        Icons.Default.Close,
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.CenterVertically),
                        contentDescription = "X icon"
                    )
                }
            }
        }
    }

}













