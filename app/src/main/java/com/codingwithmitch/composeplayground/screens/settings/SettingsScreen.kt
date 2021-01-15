package com.codingwithmitch.composeplayground.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientViewModelStoreOwner
import androidx.compose.ui.unit.dp
import com.codingwithmitch.composeplayground.screens.settings.SettingsViewModel

@Composable
fun SettingsScreen(){
    val vmStore = AmbientViewModelStoreOwner.current.viewModelStore
    val viewModel: SettingsViewModel = remember {
        createViewModel(
            viewModelClass = SettingsViewModel::class,
            storeProducer = vmStore,
            factory = MyViewModelFactory()
        )
    }
    Column() {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Settings",
            style = MaterialTheme.typography.h4
        )
        Row(
            modifier = Modifier.padding(16.dp),
        ){
            Checkbox(
                checked = viewModel.randomSetting1.value,
                onCheckedChange = {
                    viewModel.randomSetting1.value = it
                }
            )
            Text(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .align(Alignment.CenterVertically)
                    .clickable(
                        onClick = {
                            viewModel.randomSetting1.value = !viewModel.randomSetting1.value
                        }
                    )
                ,
                text = "Random setting #1",
                style = MaterialTheme.typography.body2
            )
        }
        Row(
            modifier = Modifier.padding(16.dp),
        ){
            Checkbox(
                checked = viewModel.randomSetting2.value,
                onCheckedChange = {
                    viewModel.randomSetting2.value = it
                }
            )
            Text(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .align(Alignment.CenterVertically)
                    .clickable(
                        onClick = {
                            viewModel.randomSetting2.value = !viewModel.randomSetting2.value
                        }
                    )
                ,
                text = "Random setting #2",
                style = MaterialTheme.typography.body2
            )
        }

    }
}



















