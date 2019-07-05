package com.example.android_kotlin_retrofit.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class MainActivityViewModel(app: Application) : AndroidViewModel(app) {

    private var app: Application? = null

    init {
        this.app = app
    }
}