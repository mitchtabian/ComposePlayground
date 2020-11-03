package com.codingwithmitch.composeplayground.ui.name

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.dispatch.AndroidUiDispatcher.Companion.Main
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.codingwithmitch.composeplayground.R
import com.codingwithmitch.composeplayground.ui.UIController
import com.codingwithmitch.composeplayground.ui.email.EmailFragment
import com.google.android.material.color.MaterialColors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NameFragment
constructor(
        private val viewModelFactory: ViewModelProvider.Factory
): Fragment(){

    private val TAG: String = "AppDebug"

    private val viewModel: NameViewModel by viewModels {
        viewModelFactory
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
                                            Text(stringResource(
                                                    id = R.string.app_name))
                                        },
                                        backgroundColor = MaterialTheme.colors.primary
                                )
                            },
                            bodyContent = {
                                NameCaptureScreen(
                                        navController = findNavController(),
                                        viewModel = viewModel,
                                        uiController = uiController
                                )
                            }
                    )

                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            uiController = context as UIController
        }catch (e: ClassCastException){
            e.printStackTrace()
        }
    }
}




















