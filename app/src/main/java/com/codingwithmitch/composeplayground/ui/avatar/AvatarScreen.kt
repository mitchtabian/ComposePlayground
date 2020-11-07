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
import androidx.compose.runtime.livedata.observeAsState
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

@Composable
fun loadPicture(uri: Uri): UiState<Bitmap> {
    var bitmapState: UiState<Bitmap> by state { UiState.Loading() }

    Glide.with(ContextAmbient.current)
            .asBitmap()
            .load(uri)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    bitmapState = UiState.Success(resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) { }
            })

    return bitmapState
}

@Composable
fun loadPicture(url: String): UiState<Bitmap> {
    var bitmapState: UiState<Bitmap> by state { UiState.Loading() }

    Glide.with(ContextAmbient.current)
            .asBitmap()
            .load(url)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    bitmapState = UiState.Success(resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) { }
            })

    return bitmapState
}

data class UiState<T>(
        val loading: Boolean = false,
        val exception: Exception? = null,
        val data: T? = null
) {
    /**
     * True if this contains an error
     */
    val hasError: Boolean
        get() = exception != null

    /**
     * True if this represents a first load
     */
    val initialLoad: Boolean
        get() = data == null && loading && !hasError

    companion object{
        fun<T> Success(data: T?): UiState<T>{
            return UiState(
                    data=data,
                    loading = false
            )
        }

        fun<T> Loading(): UiState<T>{
            return UiState(loading = true)
        }
    }
}

fun <T> UiState<T>.copyWithResult(value: Result<T>): UiState<T> {
    return when (value) {
        is Result.Success -> copy(loading = false, exception = null, data = value.data)
        is Result.Error -> copy(loading = false, exception = value.exception)
    }
}

/**
 * A generic class that holds a value or an exception
 */
sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

/**
 * `true` if [Result] is of type [Success] & holds non-null [Success.data].
 */
val Result<*>.succeeded
    get() = this is Result.Success && data != null

fun <T> Result<T>.successOr(fallback: T): T {
    return (this as? Result.Success<T>)?.data ?: fallback
}


// TODO
// Figure out why the image gets set back to default on rotation...















