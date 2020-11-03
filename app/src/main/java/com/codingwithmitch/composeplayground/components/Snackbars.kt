package com.codingwithmitch.composeplayground.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Snackbar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.dispatch.AndroidUiDispatcher
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BasicSnackbarWithText(
    message: String,
    delay: Long,
    finish: () -> Unit // hide the snackbar after a delay
){
    ConstraintLayout(
        modifier = Modifier.fillMaxHeight()
    ) {
        val (snackbar) = createRefs()
        Snackbar(
            text = { Text(text = message) },
            modifier = Modifier
                .padding(16.dp)
                .constrainAs(snackbar){
                    bottom.linkTo(
                        parent.bottom
                    )
                }

        )
        CoroutineScope(AndroidUiDispatcher.Main).launch {
            delay(delay)
            finish()
        }
    }

}