package com.codingwithmitch.composeplayground.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.codingwithmitch.composeplayground.BaseApplication
import com.codingwithmitch.composeplayground.R


class MainActivity : AppCompatActivity(), UIController{

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as BaseApplication).init()
        supportFragmentManager.fragmentFactory = (application as BaseApplication).fragmentFactory
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun hideKeyboard() {
        val imm: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = currentFocus
        if (view == null) {
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}















