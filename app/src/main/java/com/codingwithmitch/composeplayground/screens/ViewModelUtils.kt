package com.codingwithmitch.composeplayground.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import kotlin.reflect.KClass

fun <VM : ViewModel> createViewModelLazy(
    viewModelClass: KClass<VM>,
    storeProducer: () -> ViewModelStore,
    factory: ViewModelProvider.Factory,
): Lazy<VM> {
    return ViewModelLazy(viewModelClass, storeProducer, {factory})
}