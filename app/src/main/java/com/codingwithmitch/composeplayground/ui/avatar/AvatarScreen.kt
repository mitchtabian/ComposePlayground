package com.codingwithmitch.composeplayground.ui.avatar

import android.content.res.Configuration
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ConfigurationAmbient
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.codingwithmitch.composeplayground.R
import com.codingwithmitch.composeplayground.components.BasicSnackbarWithText
import com.codingwithmitch.composeplayground.components.NextBtn
import com.codingwithmitch.composeplayground.data.loadPicture
import com.codingwithmitch.composeplayground.ui.UIController

private val TAG: String = "AppDebug"

const val DEFAULT_APP_BAR_HEIGHT = 56

@Composable
fun AvatarScreen(
        navController: NavController,
        viewModel: AvatarViewModel,
        uiController: UIController,
        startImagePick: () -> Unit
) {

    val uriHolder: UriHolder by viewModel.uri.observeAsState(UriHolder())

    Log.d(TAG, "AvatarScreen: ${uriHolder.uri}")

    val snackbarMessage: String by viewModel.snackbarMessage.observeAsState("")

    Column() {
        CircleAvatar(
                uri = uriHolder.uri,
                clickHandler = startImagePick,
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
fun CircleAvatar(
        uri: Uri?,
        clickHandler: () -> Unit,
){
    Column(
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
    ) {
        if (uri != null){
            val loadPictureState = loadPicture(uri)

            if(loadPictureState.data != null){
                CircleImage(
                        bitmap = loadPictureState.data,
                        percentage = .5f,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        clickHandler = clickHandler,
                )
            }
        }
        else{
            CircleImage(
                    bitmap = imageResource(id = R.drawable.dummy_image).asAndroidBitmap(),
                    percentage = .5f,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    clickHandler = clickHandler,
            )
        }
    }

}

@Composable
fun CircleImage(
        bitmap: Bitmap,
        percentage: Float,
        modifier: Modifier,
        clickHandler: () -> Unit,
){

    val configuration = ConfigurationAmbient.current
    var diameter = configuration.screenWidthDp
    if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        diameter = (configuration.screenHeightDp - DEFAULT_APP_BAR_HEIGHT)
    }

    /*
        Resize image to occupy a percentage of the total space
     */
    fun adjustDiameter(d: Int, percentage: Float): Int{
        return (d*percentage).toInt()
    }

    fun createCircularBitmap(srcBitmap: Bitmap): Bitmap {
        // find the limiting dimension (height or width)
        val min = Math.min(srcBitmap.width, srcBitmap.height)
        // Init new bitmap instance
        val finalBitmap = Bitmap.createBitmap(
                min,
                min,
                Bitmap.Config.ARGB_8888 // 4 bytes per pixel
        )
        val canvas = Canvas(finalBitmap.asImageAsset())
        // Init new paint instance
        val paint = Paint()
        paint.isAntiAlias = true
        val rect = Rect(0f, 0f, min.toFloat(), min.toFloat())
        canvas.drawOval(rect, paint)
        val left = (min-srcBitmap.width)/2
        val top = (min-srcBitmap.height)/2
        val topLeftOffset = Offset(left.toFloat(), top.toFloat())
        canvas.drawImage(srcBitmap.asImageAsset(), topLeftOffset, paint)
        return finalBitmap
    }

    val bm = createCircularBitmap(bitmap)
    Image(
            asset = bm.asImageAsset(),
            modifier = modifier
                    .clip(shape = CircleShape)
                    .width(adjustDiameter(diameter, percentage).dp)
                    .height(adjustDiameter(diameter, percentage).dp)
                    .clickable(onClick = clickHandler),
            contentScale = ContentScale.Fit,
    )
}





// TODO
// Figure out why the image gets set back to default on rotation...















