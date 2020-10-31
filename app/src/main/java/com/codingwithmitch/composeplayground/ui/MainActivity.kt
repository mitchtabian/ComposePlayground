package com.codingwithmitch.composeplayground.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.codingwithmitch.composeplayground.R

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Profile ()
        }

    }
}

@Composable
fun Profile() {
    val image = imageResource(id = R.drawable.resource1)
    MaterialTheme{
        ScrollableColumn (
            modifier = Modifier.padding(16.dp)
        ){
            val imageModifier = Modifier
                .preferredHeight(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp))

            Image(
                image,
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )

            val columnModifer = Modifier
                .fillMaxHeight()
            Column(
                modifier = columnModifer,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    "Mitch Tabian",
                    style = typography.h6,
                    modifier = Modifier
                        .padding(top = 8.dp,)
                )
                Text(
                    "Abbotsford, BC, Canada",
                    style = typography.subtitle1,
                    maxLines = 1,
                    fontSize = 12.sp,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    stringResource(id = R.string.example_body),
                    style = typography.body1,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(top = 10.dp,)

                )
            }
        }
    }
}


@Preview
@Composable
fun Preview() {
    Profile()
}











