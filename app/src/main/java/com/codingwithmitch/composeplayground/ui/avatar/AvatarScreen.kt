package com.codingwithmitch.composeplayground.ui.avatar

import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.runtime.dispatch.AndroidUiDispatcher.Companion.Main
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ConfigurationAmbient
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.codingwithmitch.composeplayground.R
import com.codingwithmitch.composeplayground.components.BasicSnackbarWithText
import com.codingwithmitch.composeplayground.components.NextBtn
import com.codingwithmitch.composeplayground.ui.UIController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private val TAG: String = "AppDebug"

const val DEFAULT_APP_BAR_HEIGHT = 56

@Composable
fun AvatarScreen(
        navController: NavController,
        viewModel: AvatarViewModel,
        uiController: UIController,
        startImagePick: () -> Unit
) {

    val uri: UriHolder by viewModel.uri.observeAsState(UriHolder())
    uri.uri?.let { viewModel.setUriHolder(it) }

    Log.d(TAG, "AvatarScreen: ${viewModel.uriHolder.uri}")

    val snackbarMessage: String by viewModel.snackbarMessage.observeAsState("")

    Column() {
        CircleAvatar(
                uri = viewModel.uriHolder.uri,
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
    val imageBitmap = stateFor <Bitmap?> (null) { null }
    val context = ContextAmbient.current

    if (uri != null){
        // Run only if @param uri has changed since last time.
        onCommit(uri){
            Log.d(TAG, "CircleAvatar: URI: ${uri}")
            var target: CustomTarget<Bitmap>? = null
            val glide = Glide.with(context)
            val job = CoroutineScope(Main).launch {
                target = object : CustomTarget<Bitmap>(){
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                        imageBitmap.value = resource
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                    }
                }
                glide
                        .asBitmap()
                        .load(uri)
                        .into(target!!)
            }
            onDispose {
                imageBitmap.value = null
                glide.clear(target)
                job.cancel()
            }
        }
    }

    val bm = imageBitmap.value
    Column(
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

    ) {
        CircleImage(
                bitmap = bm,
                percentage = .5f,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                clickHandler = clickHandler,
        )
    }
}

@Composable
fun CircleImage(
        bitmap: Bitmap?,
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

    val imageBitmap = stateFor <Bitmap?> (null) { null }
    if(bitmap != null){
        onCommit(bitmap){
            val bm = createCircularBitmap(bitmap)
            imageBitmap.value = bm
            onDispose {
                imageBitmap.value = null
            }
        }
    }
    Image(
            asset = imageBitmap.value?.asImageAsset()?: imageResource(id = R.drawable.dummy_image),
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















