package com.codingwithmitch.composeplayground.ui.avatar

import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.text.style.ClickableSpan
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.FirstBaseline
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.dispatch.AndroidUiDispatcher.Companion.Main
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ConfigurationAmbient
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.DensityAmbient
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.ui.tooling.preview.Preview
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.codingwithmitch.composeplayground.R
import com.codingwithmitch.composeplayground.components.BasicSnackbarWithText
import com.codingwithmitch.composeplayground.components.NextBtn
import com.codingwithmitch.composeplayground.ui.UIController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.cos
import kotlin.math.sin

private val TAG: String = "AppDebug"

@Composable
fun AvatarScreen(
        navController: NavController,
        viewModel: AvatarViewModel,
        uiController: UIController,
        startImagePick: () -> Unit
) {

    val uriHolder: UriHolder by viewModel.uri.observeAsState(UriHolder(null))

    val snackbarMessage: String by viewModel.snackbarMessage.observeAsState("")

    Column() {
        CircleAvatar(
                uri = if(uriHolder.uri == null) null else uriHolder.uri,
                clickHandler = startImagePick,
                iconConfig = IconConfig(
                        angle = 45f,
                        iconSize = IconSize.small(),
                        iconAsset = vectorResource(id = R.drawable.ic_baseline_image_search_24)
                )
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
        iconConfig: IconConfig? = null, // null = no icon
){
    Log.d(TAG, "CircleAvatar: REDRAW")

    // Get width of image and use that to set the width of the icon
    var imageWidth by remember { mutableStateOf(0)  }
    var r by remember { mutableStateOf(0)  }

    WithConstraints(
            modifier = Modifier.clickable(onClick = clickHandler)
    ) {
        val constraints = this.constraints
        val configuration = ConfigurationAmbient.current
        var maxImgHeight = (constraints.maxWidth*0.5)
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            maxImgHeight = (constraints.maxHeight*0.5)
        }

        val image = stateFor <ImageAsset?> (null) { null }
        val context = ContextAmbient.current

        if (uri != null){
            onCommit(uri){
                var target: CustomTarget<Bitmap>? = null
                val glide = Glide.with(context)
                Log.d(TAG, "CircleAvatar: uri NOT null")

                val job = CoroutineScope(Main).launch {
                    target = object : CustomTarget<Bitmap>(){
                        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                            image.value = resource.asImageAsset()
                            Log.d(TAG, "onResourceReady: SETTING ASSET: ${image.value}")
                        }

                        override fun onLoadCleared(placeholder: Drawable?) {
                            Log.d(TAG, "onLoadCleared: called")
                        }
                    }

                    glide
                            .asBitmap()
                            .load(uri)
                            .into(target!!)
                }
            }
        }

        var theImage = image.value
        if(theImage == null){
            theImage = imageResource(id = R.drawable.dummy_image)
        }
        MyBox(
                asset = theImage,
                maxImgHeight = maxImgHeight.toInt(),
                iconConfig = iconConfig,
        )
    }
}


@Composable
fun MyBox(
        asset: ImageAsset,
        maxImgHeight: Int,
        iconConfig: IconConfig? = null,
){
    var r = 0
    var imageWidth = 0
    Box(
            modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
    ) {
        Image(
                asset = asset,
                modifier = Modifier
                        .align(Alignment.Center)
                        .width(with(DensityAmbient.current) { maxImgHeight.toDp() })
                        .height(with(DensityAmbient.current) { maxImgHeight.toDp() })
                        .clip(shape = CircleShape)
                        .layout { measurable, constraints ->
                            val placeable = measurable.measure(constraints)
                            imageWidth = placeable.width
                            r = imageWidth / 2
                            layout(placeable.width, placeable.height) {
                                placeable.placeRelative(0, 0)
                            }
                        },
                contentScale = ContentScale.Fit,
        )
        if(iconConfig != null){
            Surface(
                    modifier = Modifier
                            .align(Alignment.Center)
                            .width(with(DensityAmbient.current){(imageWidth*iconConfig.iconSize.size).toInt().toDp()})
                            .layout { measurable, constraints ->
                                val placeable = measurable.measure(constraints)
                                layout(placeable.width, placeable.height) {
                                    placeable.placeRelative((r * sin(iconConfig.angle)).toInt(), (r * cos(iconConfig.angle)).toInt())
                                }
                            },
                    elevation = 32.dp,
                    shape = RoundedCornerShape(8.dp)
            ) {
                Image(
                        iconConfig.iconAsset,
                        modifier = Modifier
                                .background(
                                        color = Color.White,
                                )
                        ,
                        contentScale = ContentScale.FillWidth,
                )
            }
        }
    }
}

class IconConfig(
        val angle: Float,
        val iconSize: IconSize,
        val iconAsset: VectorAsset
) {

    init {
        if(angle > 360 || angle < 0){
            throw Exception("IconAngle: angle must be between 0 - 360.")
        }
    }

}


class IconSize(
        val size: Float
) {

    init {
        if(size < 0 || size > 1){
            throw Exception("IconSize: size must be between 0 - 1.")
        }
    }

    companion object{

        fun extraSmall(): IconSize {
            return IconSize(0.05f)
        }

        fun small(): IconSize {
            return IconSize(0.15f)
        }

        fun medium(): IconSize {
            return IconSize(0.25f)
        }

        fun Large(): IconSize {
            return IconSize(0.35f)
        }

        fun extraLarge(): IconSize {
            return IconSize(0.45f)
        }
    }

}


//@Preview
//@Composable
//fun preview(){
//    SelectAvatar("", {})
//}












