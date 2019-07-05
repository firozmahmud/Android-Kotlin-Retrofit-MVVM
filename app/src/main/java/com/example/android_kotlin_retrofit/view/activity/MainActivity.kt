package com.example.android_kotlin_retrofit.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.android_kotlin_retrofit.R
import com.example.android_kotlin_retrofit.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private var viewmodel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }
}
