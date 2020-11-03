package com.codingwithmitch.composeplayground.ui.avatar

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.dispatch.AndroidUiDispatcher.Companion.Main
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.ui.tooling.preview.Preview
import com.codingwithmitch.composeplayground.R
import com.codingwithmitch.composeplayground.components.BasicSnackbarWithText
import com.codingwithmitch.composeplayground.components.NextBtn
import com.codingwithmitch.composeplayground.ui.UIController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

private val TAG: String = "AppDebug"

@Composable
fun AvatarScreen(
        navController: NavController,
        viewModel: AvatarViewModel,
        uiController: UIController
) {

    val avatar: String by viewModel.avatarUrl.observeAsState("")

    val snackbarMessage: String by viewModel.snackbarMessage.observeAsState("")

    Log.d(TAG, "AvatarScreen: VIEWMODEL: ${viewModel}")

    Column() {
        SelectAvatar(
            avatar = avatar,
            onAvatarChanged = {
                viewModel.onAvatarChanged(it)
            }
        )
        NextBtn {
            // go to final screen?
        }
    }
    if(!snackbarMessage.isBlank()){
        uiController.hideKeyboard()
        BasicSnackbarWithText(
                snackbarMessage,
                2000,
                {viewModel.setSnackbarMessage("")}
        )
    }
}


@Composable
fun SelectAvatar(
    avatar: String,
    onAvatarChanged: (String) -> Unit
){
    val image = imageResource(id = R.drawable.dummy_image)

    val imageModifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(4.dp))
    Image(
        image,
        modifier = imageModifier,
        contentScale = ContentScale.FillWidth
    )

    TODO("figure out how to center this in the middle of image... ConstraintLayout?")
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier.padding(top = 100.dp)
//    ) {
//        Icon(
//            vectorResource(id = R.drawable.ic_baseline_image_search_24)
//        )
//        Text(
//            "Select an image"
//        )
//    }
}













