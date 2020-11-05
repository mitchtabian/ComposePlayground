package com.codingwithmitch.composeplayground.ui.avatar

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts.*
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.codingwithmitch.composeplayground.R
import com.codingwithmitch.composeplayground.ui.UIController

const val REQUEST_IMAGE_GET = 1

class AvatarFragment
constructor(
    private val viewModelFactory: ViewModelProvider.Factory
): Fragment() {

    private val TAG: String = "AppDebug"

    private val viewModel: AvatarViewModel by viewModels {
        viewModelFactory
    }

    private val activityResult = registerForActivityResult(StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            intent?.data?.let { uri ->
                uri.path?.let {path ->
                    viewModel.onAvatarChanged(path)
                }
            }
        }
    }

    private lateinit var uiController: UIController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.compose_view, container, false
        ).apply {
            findViewById<ComposeView>(R.id.compose_view).setContent {
                // In Compose world
                MaterialTheme {
                    Scaffold(
                            topBar = {
                                TopAppBar(
                                    title = {
                                        Text(
                                            stringResource(
                                                id = R.string.app_name
                                            )
                                        )
                                    },
                                    backgroundColor = MaterialTheme.colors.primary
                                )
                            },
                            bodyContent = {
                                AvatarScreen(
                                    navController = findNavController(),
                                    viewModel = viewModel,
                                    uiController = uiController,
                                    startImagePick = {startImagePick()}
                                )
                            },
                            backgroundColor = Color(0xf2f2f2f2),
                    )

                }
            }
        }
    }

    fun startImagePick(){
        activity?.let {
            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "image/*"
            }
            activityResult.launch(intent)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            uiController = context as UIController
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }
    }
}











