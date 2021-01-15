package com.codingwithmitch.composeplayground.screens

import androidx.lifecycle.*
import kotlin.reflect.KClass

fun <VM : ViewModel> createViewModel(
    viewModelClass: KClass<VM>,
    storeProducer: ViewModelStore,
    factory: ViewModelProvider.Factory,
): VM {
    return ViewModelProvider(storeProducer, factory).get(viewModelClass.java)
}

// lazy version of createViewModel
fun <VM : ViewModel> createViewModelLazy(
    viewModelClass: KClass<VM>,
    storeProducer: ViewModelStore,
    factory: ViewModelProvider.Factory,
): Lazy<VM> {
    return ViewModelLazy(viewModelClass, { storeProducer }, { factory })
}


















