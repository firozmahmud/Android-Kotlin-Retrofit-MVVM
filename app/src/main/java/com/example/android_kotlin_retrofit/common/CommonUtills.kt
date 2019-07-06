package com.example.android_kotlin_retrofit.common

import android.app.ActionBar
import android.app.Activity
import android.content.Context
import android.widget.Toast

fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}