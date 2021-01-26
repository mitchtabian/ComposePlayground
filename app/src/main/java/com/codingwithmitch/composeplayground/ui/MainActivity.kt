package com.codingwithmitch.composeplayground.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codingwithmitch.composeplayground.R

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, MainFragment())
            .commit()
    }
}





































